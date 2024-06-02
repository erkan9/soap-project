## SOAP Service and Client Readme

### SOAP Service

The SOAP service provides functionality to retrieve information about cars. It runs on port 8081.

#### How to Start the SOAP Service
1. Run the SOAP service by executing the main method in the SoapService class or using `mvn spring-boot:run`.

#### How to Generate WSDL
- To generate the WSDL file, use the following URL: [http://localhost:8081/carws/carsService.wsdl]
- 
![Screenshot_5](https://github.com/erkan9/soap-service/assets/63397975/c7dac584-6a0b-4e0a-a0fe-758aa0858dd7)


#### Additional Information
- Cars can be retrieved by their ID, and this functionality is provided by the service.
- Cars are seeded into a collection upon the startup of the service.

### SOAP Client

The SOAP client interacts with the SOAP service to retrieve car information. It runs on port 8082.

#### How to Start the SOAP Client
1. Run the SOAP client by executing the main method in the SoapClient class or using `mvn spring-boot:run`.

#### Starting the Application
- Start the SOAP service first, then start the SOAP client to interact with it.

![Screenshot_4](https://github.com/erkan9/soap-service/assets/63397975/6d5d8868-92be-42ba-bc28-aa8d7f325f7b)

Note: There is one parent module and two submodules: soap-service and soap-client.
