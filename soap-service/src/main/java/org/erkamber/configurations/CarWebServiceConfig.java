package org.erkamber.configurations;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Web service configuration class.
 */
@EnableWs
@Configuration
public class CarWebServiceConfig extends WsConfigurerAdapter {

    /**
     * Registers the MessageDispatcherServlet with the application context.
     *
     * @param applicationContext the application context
     * @return the servlet registration bean
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> carMessageDispatcherServlet(final ApplicationContext applicationContext) {

        final MessageDispatcherServlet servlet = new MessageDispatcherServlet();

        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/carws/*");
    }

    /**
     * Creates a WSDL definition for the car web service.
     *
     * @param carSchema the XSD schema
     * @return the WSDL 1.1 definition
     */
    @Bean(name = "carsService")
    public DefaultWsdl11Definition carWsdl11Definition(final XsdSchema carSchema) {

        final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

        wsdl11Definition.setSchema(carSchema);
        wsdl11Definition.setLocationUri("/carws");

        wsdl11Definition.setPortTypeName("CarServicePort");
        wsdl11Definition.setTargetNamespace("http://car-management-system");

        return wsdl11Definition;
    }

    /**
     * Loads the XSD schema for the car web service.
     *
     * @return the XSD schema
     */
    @Bean
    public XsdSchema carSchema() {
        return new SimpleXsdSchema(new ClassPathResource("cars.xsd"));
    }
}