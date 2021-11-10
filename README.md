Stack : Java, Spring, Vue.js (embedded), H2 (embedded)

# Getting Started

### Install latest versions:
* [Java] (https://www.oracle.com/java/technologies/downloads/)
* [Maven] (https://maven.apache.org/download.cgi)

### Run application in root directory from command prompt:

mvn spring-boot:run

or

mvn clean install
cd target
java -jar FinalProject-0.0.1-SNAPSHOT - в папке target выполнить команду


http://localhost:8080/index.html

* [H2 console:]

http://localhost:8080/h2-console/

URL: jdbc:h2:file:./data/news
Login: admin
Password: admin

H2 stores data in file, max-file-size 1Mb, 
ZIP must contain only article.txt with at least two lines (header, content)

* [Swagger-UI:]
* 
http://localhost:8080/swagger-ui/
