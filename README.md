# underArmour
How to Run this Project 

Once the Project is checked out or set up in the local . Execute the command below from root folder > this will run the application in dev mode . If need to do a stand alone deployment run with appending -jar

mvn spring-boot:run

Database schema and data can be viewed with below URL once the server is started 


http://localhost:8080/h2-console/login.jsp

Driver Class:	org.h2.Driver
JDBC URL:	jdbc:h2:mem:testdb


Framework used :  

Developed with Spring boot framework, H2 in-memory database, and tomcat server. here the Implementation has used inbuilt set up of spring boot. H2 database with the database table and schema will be loaded and created during the server startup. This is to avoid any complexity or dependency for the database for this sample micro-services implementation.

Data look from the database is implemented with Spring data JDBC template.

Project structure improvement :

The sample project is created with a simple project structure. The structure can be maintained and improved as controller, service, dao architecture. It will be good for better packaging of files. It's better to separate the repository, controller and service classes for better maintainability..


Exception and Validation Improvement : Exception handling and validation of http requests are not implemented now . It have to be take in up as the better coding standard in next iteration . The query have to be seperated from the java code. 


Security Improvement : The services have to be wrapped with authentication and spring security . Https for the services can be used for data security


Database connectivity improvement :

This service runs with developer test database . This have to be improved with persistent storage .Any other framework like JPA and hibernate can be used of database look up .Which will have the advantages of this framework. Connection can be implemented from a datasource for better maintainability . 



Performance and scalability Improvement :

Currently, a relational database system is used. It would preferable to use an in-memory database cache like Redis cache which uses key-value pair storage for a user whose chat session is active. The message should be archived to cold storage system directly from the Redis cache when the Time to live of the object is expired which is calculated based on the time out of the message. This improves the scalability and performance of the services multifold to avoid database look up. Also the disc usage of the database.


Design Improvement - Future feature to be implemented.

Story :  Moving the expired messages to Cold storage -:

Suggestion 1 :
This feature is not developed now. The preferable design for this implementation should be a batch process to pull the data from the message table and insert to any system where the expired messages to be stored. I prefer this to be implemented as this will avoid the database contention and will improve the response time for the micro services  during the messages are looked up . Services can be scaled easily without this Bottleneck 

Suggestion 2 :
If the expired messages are to be archived during the runtime of micro-services, it would be preferable to have a queue and a listener implementation or a new thread than the main thread inserting the expired messages to the cold storage.





