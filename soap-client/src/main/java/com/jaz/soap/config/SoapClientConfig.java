package com.jaz.soap.config;

import com.jaz.soap.client.EmployeeSoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.jaz.soap.client");
        return jaxb2Marshaller;
    }

    @Bean
    public EmployeeSoapClient employeeClient(Jaxb2Marshaller jaxb2Marshaller) {
        EmployeeSoapClient testClient = new EmployeeSoapClient();
        testClient.setDefaultUri("http://localhost:8088/mockEmployeePortSoap11");
        testClient.setMarshaller(jaxb2Marshaller);
        testClient.setUnmarshaller(jaxb2Marshaller);
        return testClient;
    }
}