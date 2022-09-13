package com.hosny.client;

import com.hosny.loanEligibility.Acknowledgement;
import com.hosny.loanEligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate webServiceTemplate;

    public Acknowledgement getLoanStatus(CustomerRequest request) {
        webServiceTemplate = new WebServiceTemplate(marshaller);
        Acknowledgement acknowlegement = (Acknowledgement) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws", request);
        return acknowlegement;

    }
}
