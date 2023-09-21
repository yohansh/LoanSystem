package com.example.LoanDistributionSystem.constants;

public interface Routes {
    
    static final String ADD_LOAN = "/loans/add";
    static final String GET_ALL_LOANS = "/loans";
    
    static final String BASE_URL = "/loan-details";
    
    static final String V1 = "/v1";

    static final String GET_LOAN_BY_LOAN_ID = "/loans/{loanId}";
    static final String GET_LOAN_BY_CUSTOMER_ID = "/loans/{customerId}";
    static final String GET_LOAN_BY_LENDER_ID = "/loans/{lenderId}";
    
}
