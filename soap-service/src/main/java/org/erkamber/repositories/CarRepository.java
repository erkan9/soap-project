package org.erkamber.repositories;

import jakarta.annotation.PostConstruct;
import org.erkamber.entities.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarRepository {

    private final Map<Long, Car> cars = new HashMap<>();

    @PostConstruct
    public void populateDummyData() {
        cars.put(1L, new Car(1L, "Model S", "Tesla", 2021));
        cars.put(2L, new Car(2L, "Mustang", "Ford", 2020));
        cars.put(3L, new Car(3L, "Civic", "Honda", 2019));
        cars.put(4L, new Car(4L, "Corolla", "Toyota", 2018));
        cars.put(5L, new Car(5L, "Impreza", "Subaru", 2017));
    }

    public Car getCarById(Long id) {
        return cars.get(id);
    }
}