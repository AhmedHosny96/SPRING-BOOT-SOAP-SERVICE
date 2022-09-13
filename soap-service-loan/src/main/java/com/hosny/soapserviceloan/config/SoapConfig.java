package com.hosny.soapserviceloan.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.ServletRegistration;

@Configuration
@EnableWs
public class SoapConfig {


    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletServletRegistrationBean
            (ApplicationContext context) {

        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet , "/ws/*");
    }


    @Bean(name = "loanEligibility")
    public DefaultWsdl11Definition wsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

        definition.setPortTypeName("LoanEligibilityIndicator");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://www.hosny.com/soap-service-loan");
        definition.setSchema(schema());
        return definition;
    }

    @Bean
    public XsdSchema schema(){
        return new SimpleXsdSchema(new ClassPathResource("loanEligibilty.xsd"));
    }

}
