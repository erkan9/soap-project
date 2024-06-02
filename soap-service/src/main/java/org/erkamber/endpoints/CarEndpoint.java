package org.erkamber.endpoints;

import org.erkamber.entities.Car;
import org.erkamber.entities.GetCarRequest;
import org.erkamber.entities.GetCarResponse;
import org.erkamber.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Endpoint class for managing cars.
 */
@Endpoint
public class CarEndpoint {

    private static final String NAMESPACE = "http://car-management-system";

    private final CarService carService;

    /**
     * Constructs a new CarEndpoint with the given CarService.
     *
     * @param carService the service for managing cars
     */
    @Autowired
    public CarEndpoint(final CarService carService) {
        this.carService = carService;
    }

    /**
     * Handles requests for retrieving a car.
     *
     * @param carRequest the request for retrieving a car
     * @return the response containing the requested car
     */
    @PayloadRoot(namespace = NAMESPACE, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCarRequest(@RequestPayload final GetCarRequest carRequest) {
        final GetCarResponse carResponse = new GetCarResponse();

        final Car carById = this.carService.getCarById(carRequest.getId());
        carResponse.setCar(carById);

        return carResponse;
    }
}