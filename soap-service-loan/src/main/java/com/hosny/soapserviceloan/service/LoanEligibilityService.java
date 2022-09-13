package com.hosny.soapserviceloan.service;


import com.hosny.soap_service_loan.Acknowledgement;
import com.hosny.soap_service_loan.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibilityService {

    public Acknowledgement loanLiabilityAcknowledgement(CustomerRequest request) {

        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> criteriaMisMatch = acknowledgement.getCriteriaMismatch();

        // check eligibility conditions

        if (!(request.getAge() > 30 && request.getAge() < 60)) {
            criteriaMisMatch.add("Employee age should be in between 30 and 60");

        }
        if (!(request.getCibilScore() > 500)) {
            criteriaMisMatch.add("Cibil score is low please try after 6 months");
        }
        if (!(request.getYearlyIncome() > 1000000)) {
            criteriaMisMatch.add("Yearly income is low");
        }

        if (criteriaMisMatch.size() > 0) {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            acknowledgement.setIsEligible(true);
            acknowledgement.setApprovedAmount(2000000);
        }

        return acknowledgement;

    }
}
