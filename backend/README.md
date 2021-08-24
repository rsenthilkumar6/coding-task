# Backend Application

This Repository contains the code for backend task - **Credit Card Validator**.

|  |  |
|--|--|
| Language | Java  |
| Framework | spring boot |
| Addition Features | Swagger UI / Docker |


**Credit Card Validator Service**

The validator services validates the given credit card against the standard method (startswith & length) along with Luhn Algorithm

| method | path | description | authorization |
|--|--|--|--|
| POST | /api/validate | validate the given credit card number | N/A |	 

# To Run

Please ensure JAVA_HOME and MAVEN paths are available and execute the below command to start the application

In Windows

> ./run.bat

In Linux

> ./run.sh

Access the Swagger UI

[http://localhost:9001/swagger-ui.html](http://localhost:9001/swagger-ui.html)


If docker installed, application will start in docker container if not will start as java application

## Configurations

Please refer to application.property file to modify server port if required
