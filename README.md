App Name: Wiki Place Name Search Service App

Author: Turgut Can Ozdemir

E-mail: turgutcanozdemir@gmail.com

Release Date: 03/2023

Please feel free to contact me if you have any questions or suggestions.

GENERAL INFO:

* This application was developed using the knowledge and libraries obtained from the 'Java Applications' course, which was offered by the 'C and Systems Programmers Association' and taught by Oguz Karan. 

* The application uses the 'GeoNames countryInfo WebService' API.

BASIC REQUIREMENTS:

* To run the application, you must first enter the database information that you previously created in the application-dev.properties section of the resources. The following information must be filled in:

#JDBC properties
spring.datasource.url=jdbc:postgresql://localhost:5432/trial23_placenameappdb_yourname
spring.datasource.username=postgresuser
spring.datasource.password=yourpassword

* Additionally, you need to replace the default geonames username with your own username in the app.geonames.url in the application.properties file.

* In order for Maven to build the application, you need to install the modules in your local.

FEATURES:

* You can retrieve Wikipedia information about cities by using their names (e.g., London, Istanbul, Paris, Berlin).

* The RestTemplate library is used to retrieve data in JSON format from GeoNames.

* PostgreSQL is used in the application for data storage.

* You can change the Jpa Props to update or create so that your database is updated or recreated every time the application is opened. 

* The application extracts data from GeoNames and saves them to the database. After the registration process, the application provides queries made from the database. This method provides protection from the cost if there is any usage quota or cost in using the API.

* In the repository layer of the application, entities such as PlaceName, PlaceNameInfo, and PlaceNameQueryInfo are defined to save different properties of the queries to the database.

* The application was written using Spring Boot.

* Dependency injection has been implemented at all stages of the application.

* The application has been designed using the layered architecture pattern (repository, service, and application).

* PlaceNameServiceHelper functions as a facade layer as a branch layer to facilitate the use of the application's service codes.

* A modular structure is used in the application.

* While designing the modular structure, parent pom properties are used in pom.xml
