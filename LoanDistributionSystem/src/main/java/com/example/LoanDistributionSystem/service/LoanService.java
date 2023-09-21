package com.example.LoanDistributionSystem.service;

import com.example.LoanDistributionSystem.exceptions.LoanValidationException;
import com.example.LoanDistributionSystem.model.Loan;

import java.util.List;

public interface LoanService {
    Loan addLoan(Loan loan) throws LoanValidationException;
    List<Loan> getAllLoans();
    Loan getLoanById(String loanId);
    List<Loan> getLoansByCustomerId(String customerId);
    List<Loan> getLoansByLenderId(String lenderId);
}
