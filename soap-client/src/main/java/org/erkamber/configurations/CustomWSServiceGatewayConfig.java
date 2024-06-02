package org.erkamber.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Configuration
public class CustomWSServiceGatewayConfig extends WebServiceGatewaySupport {

    @Bean
    public Jaxb2Marshaller customMarshaller() {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.erkamber.entities");

        return marshaller;
    }

    @Bean
    public CarSoapClient customSoapClient(final Jaxb2Marshaller customMarshaller) {

        final CarSoapClient client = new CarSoapClient();

        client.setDefaultUri("http://localhost:8081/carws");
        client.setMarshaller(customMarshaller);
        client.setUnmarshaller(customMarshaller);

        return client;
    }
}