Stack : Java, Spring, Vue.js (embedded), H2 (embedded)

### Install latest versions:
* Java 11+ (https://www.oracle.com/java/technologies/downloads/)
* Maven (https://maven.apache.org/download.cgi)

### Run application in root directory (NewsFeed) from command prompt:

* mvn spring-boot:run

or

* mvn clean install
* cd target
* java -jar FinalProject-0.0.1-SNAPSHOT.jar

#### Get Articles:

http://localhost:8080/index.html

#### Upload Articles:

http://localhost:8080/upload.html

#### H2 console:

http://localhost:8080/h2-console/

* URL: jdbc:h2:file:./src/main/resources/news
* Login: admin
* Password: admin

H2 stores data in file, max-file-size 1Mb, 
ZIP must contain only article.txt with at least two lines (header, content)

#### Swagger-UI:

http://localhost:8080/swagger-ui/
