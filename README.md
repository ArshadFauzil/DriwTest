# DriwTest - Project Setup
#### This application requires a PostgreSQL DB setup, with the following credentials, or the credentials can be setup in the following file.
```
src/main/resources/application.properties
...
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username= postgres
spring.datasource.password=intel@123
``` 
#### Run the following scripts in the Database as defined in the above file.
```
CREATE TABLE Product (
    pid int,
    name varchar(255),
    unitprice float,
    units_per_carton int
);

INSERT INTO Product (pid, name, unitprice, units_per_carton)
VALUES (0, 'Penguin-ears', 8.75, 20);

INSERT INTO Product (pid, name, unitprice, units_per_carton)
VALUES (1, 'Horseshoe', 165, 5);
```
#### This project was built using Maven which can be installed as found in https://maven.apache.org/install.html.
#### After adding Maven to your path, run the following command to up the REST API in the root of the Spring Boot project.
```
mvn package && java -jar target/DriwTest-1.0-SNAPSHOT.jar
```
#### The serverside of the application is now running.
#### Run the following commands to up the frontend application.
```
cd Frontend/shopping-cart
npm install
npm run build
npm run serve
```
#### The front end should be running now. The application can be accessed using the following URL, or whatever the URL that is shown on the command line.
```
http://localhost:8080/
```
#### Due to the browser's security settings related to CORS, you may not view any data as the Vue JS app loads.
#### This is because the backend requests are made from the same origin as the front end app.
#### To make it work install the browser extension found in https://chrome.google.com/webstore/detail/moesif-orign-cors-changer/digfbfaphojjndkpccljibejjbppifbc?hl=en-US if you're using Chrome as your browser.
#### You can also install the same extension for the browser of your choice and turn on the extension.
#### Once you reload the app you should be able to view the data, and use the app.

