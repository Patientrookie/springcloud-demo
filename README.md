# springcloud-demo

zipkin下载使用：
# get the latest source
git clone https://github.com/openzipkin/zipkin
cd zipkin
# Build the server and also make its dependencies
./mvnw -DskipTests --also-make -pl zipkin-server clean install
# Run the server
java -jar ./zipkin-server/target/zipkin-server-*exec.jar

F版本之后就不用自己构建zipkin,可以直接在https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/ 下载zipkin-server-2.12.9-exec.jar文件
然后java -jar xxx.jar 文件就OK了


#配置Hystrix Dashboard后访问的地址
http://localhost:1201/actuator/hystrix.stream
http://localhost:1201/hystrix/monitor 参数： 上面的url, 延迟, title
