package org.erkamber;

import org.erkamber.configurations.CarSoapClient;
import org.erkamber.entities.GetCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SoapClient {

    public static void main(String[] args) {
        SpringApplication.run(SoapClient.class);
    }

    @Autowired
    @Qualifier("customSoapClient")
    CarSoapClient carSoapClient;

    @Bean
    CommandLineRunner lookup() {

        return args -> {
            final Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the car: ");
            final Long id = scanner.nextLong();
            scanner.close();

            final GetCarResponse response = carSoapClient.getCarById(id);
            if (response != null && response.getCar() != null) {
                System.out.println(response.getCar());
            } else {
                System.out.println("Custom car with ID [" + id + "] not found");
            }
        };
    }
}