package com.example.LoanDistributionSystem.repository;

import com.example.LoanDistributionSystem.model.Loan;

import java.math.BigDecimal;
import java.util.List;

public interface LoanRepository {
    Loan addLoan(Loan loan);
    Loan getLoanById(String loanId);
    List<Loan> getAllLoans();
    List<Loan> getLoansByCustomerId(String customerId);
    List<Loan> getLoansByLenderId(String lenderId);

//    BigDecimal getRemainingAmountSumByLender(String lenderId);
//    BigDecimal getRemainingAmountSumByCustomerId(String customerId);
//    BigDecimal getRemainingAmountSumByInterest(String interest);
//
//    // New method for alert handling
//    void checkDueDatesAndLogAlerts();
}