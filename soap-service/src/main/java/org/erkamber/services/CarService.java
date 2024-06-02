package org.erkamber.services;

import org.erkamber.entities.Car;
import org.erkamber.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing cars.
 */
@Service
public class CarService {

    private final CarRepository carRepository;

    /**
     * Constructs a new CarService with the given CarRepository.
     *
     * @param carRepository the repository for car data
     */
    @Autowired
    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Retrieves a car by its ID.
     *
     * @param id the ID of the car to retrieve
     * @return the car with the specified ID, or null if no such car exists
     */
    public Car getCarById(final Long id) {
        return this.carRepository.getCarById(id);
    }
}