1. MariaDb

   spring.datasource.url=jdbc:mariadb://localhost:3306/test1
   spring.datasource.username=root
   spring.datasource.password=123456


2. Redis server is running using 

redis-server.exe

it defaults to localhost:6379


3. MongoDB 

Start server from mongod.exe

start mongoshell from mongosh.exe (coming from different zip file since version 6.0)

use mongo-java-driver



//SONAR

./gradlew sonar -Dsonar.projectKey="ultimateDbConnector"  -Dsonar.host.url=http://localhost:9000  -Dsonar.login=sqp_94c71c58c3564e9c6ca53dbf431993a5817d9b92
