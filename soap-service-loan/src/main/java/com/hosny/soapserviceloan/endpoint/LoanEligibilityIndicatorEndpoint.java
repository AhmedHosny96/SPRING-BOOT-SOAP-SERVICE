package com.hosny.soapserviceloan.endpoint;


import com.hosny.soap_service_loan.Acknowledgement;
import com.hosny.soap_service_loan.CustomerRequest;
import com.hosny.soapserviceloan.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE = "http://www.hosny.com/soap-service-loan";

    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
        return service.loanLiabilityAcknowledgement(request);
    }
}
