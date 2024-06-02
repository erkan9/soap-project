## SOAP Service and Client Readme

### SOAP Service

The SOAP service provides functionality to retrieve information about cars. It runs on port 8081.

#### How to Start the SOAP Service
1. Run the SOAP service by executing the main method in the SoapService class or using `mvn spring-boot:run`.

#### How to Generate WSDL
- To generate the WSDL file, use the following URL: [http://localhost:8081/carws/carsService.wsdl](http://localhost:8081/carws/carsService.wsdl)
![WSDL Screenshot](https://github.com/erkan9/soap-project/assets/63397975/99661bfb-dd95-40eb-922f-398a5d450744)

#### Additional Information
- Cars can be retrieved by their ID, and this functionality is provided by the service.
- Cars are seeded into a collection upon the startup of the service.

### SOAP Client

The SOAP client interacts with the SOAP service to retrieve car information. It runs on port 8082.

#### How to Start the SOAP Client
1. Run the SOAP client by executing the main method in the SoapClient class or using `mvn spring-boot:run`.

#### Starting the Application
- Start the SOAP service first, then start the SOAP client to interact with it.
![Client Screenshot](https://github.com/erkan9/soap-project/assets/63397975/8d1c4b4a-7ced-49a8-913e-9b808a1450a5)

Note: There is one parent module and two submodules: soap-service and soap-client.
