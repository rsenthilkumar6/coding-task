# Backend Application

This Repository contains the code for backend task - **Credit Card Validator**.

|  |  |
|--|--|
| Language | Java  |
| Framework | spring boot |
| Addition Features | Swagger UI |


**Credit Card Validator Service**

The validator services validates the give credit card agains the standard method (starts with & length) along with Luhn Algorithm

| method | path | description | authorization |
|--|--|--|--|
| POST | /api/validate | validate the given credit card number | N/A |	 

# To Run

Please ensure JAVA_HOME and MAVEN path available 

Execute the below command to start the application

In Windows

> ./run.bat

In Linux

> ./run.sh

Access the Swagger UI

[http://localhost:9001/swagger-ui.html](http://localhost:9001/swagger-ui.html)
 
## Configurations

Please refer to application.property file to modify server port if required

