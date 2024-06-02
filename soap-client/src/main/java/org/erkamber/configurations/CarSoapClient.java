package org.erkamber.configurations;

import org.erkamber.entities.GetCarRequest;
import org.erkamber.entities.GetCarResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class CarSoapClient extends WebServiceGatewaySupport {

    /**
     * Retrieves car information by ID from the SOAP service.
     *
     * @param id The ID of the car to retrieve.
     * @return The response containing car information.
     */
    public GetCarResponse getCarById(final Long id) {
        final GetCarRequest request = new GetCarRequest();
        request.setId(id);

        return (GetCarResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/carws/", request,
                        new SoapActionCallback("http://car-management-system/GetCarRequest"));
    }
}