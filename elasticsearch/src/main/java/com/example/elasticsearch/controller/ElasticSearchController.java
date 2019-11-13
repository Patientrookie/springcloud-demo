package com.example.elasticsearch.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.elasticsearch.entity.Person;

import com.example.elasticsearch.service.JestDataBaseService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaqi
 * @Description:
 * @Date: Created in 14:54 11/11/2019
 * @modified By:
 */

@RestController
@RequestMapping(value = "/elasticSearch")
public class ElasticSearchController {

    @Autowired
    JestClient jestClient;

    @Autowired
    JestDataBaseService<Person> jestDataBaseService;

    @GetMapping("/query")
    @ApiOperation(value = "查询ES的accounts index的type为person的,并且desc字段为“数据库管理”全部数据")
    public List<Person> query(){
        //组装查询参数
        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();
        JSONObject json3 = new JSONObject();

        json3.put("desc","数据库管理");
        json2.put("match_phrase",json3);
        json1.put("query",json2);

        List<Person> personList = new ArrayList<Person>();
        Search search = new Search.Builder(json1.toJSONString()).addIndex("accounts").addType("person").build();

        try {
            SearchResult searchResult = jestClient.execute(search);
            List<SearchResult.Hit<Person,Void>> hits = searchResult.getHits(Person.class);
            for(SearchResult.Hit hit: hits){
                Person person = (Person) hit.source;
                personList.add(person);
            }
            return personList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/queryById")
    @ApiOperation(value = "根据id查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ES上的用户ID", required = true, dataType = "String")
    })
    public Person queryById(String id){
        Person person = jestDataBaseService.queryById("accounts","person",id,Person.class);
        return person;
    }

    @GetMapping("/createPerson")
    @ApiOperation(value = "向ES中写入数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ES上的用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userName", value = "用户userName", required = true, dataType = "String"),
            @ApiImplicitParam(name = "title", value = "用户title", required = true, dataType = "String"),
            @ApiImplicitParam(name = "desc", value = "用户描述", required = true, dataType = "String")
    })
    public void createPerson(String id,String userName,String title,String desc){
        Person person = new Person();
        person.setUser(userName);
        person.setTitle(title);
        person.setDesc(desc);
        jestDataBaseService.singleIndexWithId("accounts","person",id,person);
    }

}
