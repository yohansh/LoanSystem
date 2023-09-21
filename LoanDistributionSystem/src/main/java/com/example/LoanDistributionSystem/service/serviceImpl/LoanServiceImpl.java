package com.example.LoanDistributionSystem.service.serviceImpl;


import com.example.LoanDistributionSystem.exceptions.LoanValidationException;
import com.example.LoanDistributionSystem.model.Loan;
import com.example.LoanDistributionSystem.repository.LoanRepository;
import com.example.LoanDistributionSystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan addLoan(Loan loan) throws LoanValidationException {
        if (loan.getPaymentDate().isAfter(loan.getDueDate())) {
            throw new LoanValidationException("Payment date cannot be greater than due date");
        }

        return loanRepository.addLoan(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.getAllLoans();
    }

    @Override
    public Loan getLoanById(String loanId) {
        return loanRepository.getLoanById(loanId);
    }

    @Override
    public List<Loan> getLoansByCustomerId(String customerId) {
        return loanRepository.getLoansByCustomerId(customerId);
    }

    @Override
    public List<Loan> getLoansByLenderId(String lenderId) {
        return loanRepository.getLoansByLenderId(lenderId);
    }




}
