package com.hosny.controller;


import com.hosny.client.SoapClient;
import com.hosny.loanEligibility.Acknowledgement;
import com.hosny.loanEligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private SoapClient client;

    @PostMapping("/get-loan-status")
    public Acknowledgement callSoapClientForLoanStatus(@RequestBody CustomerRequest request){
        return client.getLoanStatus(request);
    }
}
