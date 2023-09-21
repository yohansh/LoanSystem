package com.example.LoanDistributionSystem.controller;


import com.example.LoanDistributionSystem.model.Loan;
import com.example.LoanDistributionSystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.LoanDistributionSystem.constants.*;



import java.time.LocalDate;

import java.util.List;


@RestController
@RequestMapping(value = Routes.BASE_URL+Routes.V1)
public class LoanDetailsController {

    @Autowired
    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }

    @Autowired
    LoanService loanService;


    @GetMapping(value = Routes.GET_ALL_LOANS)
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @PostMapping(value = Routes.ADD_LOAN)
    public void addLoad(@RequestParam(value = "customerId", required = false) String customerId,
                        @RequestParam(value = "lenderId", required = false) String lenderId,
                        @RequestParam(value = "amount", required = false) String amount,
                        @RequestParam(value = "remainingAmount", required = false) String remainingAmount,
                        @RequestParam(value = "paymentDate", required = false) String paymentDate,
                        @RequestParam(value = "interestPerDay", required = false) String interestPerDay,
                        @RequestParam(value = "dueDate", required = false) String dueDate,
                        @RequestParam(value = "penaltyPercentage", required = false) String penaltyPercentage,
                        @RequestParam(value = "dueDate", required = false) String cancel) {


        Loan loan = new Loan();
        loan.setCustomerId(customerId);
        loan.setLenderId(lenderId);
        loan.setAmount(Long.parseLong(amount));
        loan.setRemainingAmount(Long.parseLong(remainingAmount));
        loan.setPaymentDate(LocalDate.parse(paymentDate));
        loan.setInterestPerDay(interestPerDay);
        loan.setDueDate(LocalDate.parse(dueDate));
        loan.setPenaltyPercentage(penaltyPercentage);
        loan.setCancel(cancel);

        loanService.addLoan(loan);

    }


    @GetMapping(value = Routes.GET_LOAN_BY_CUSTOMER_ID)
    public List<Loan> getLoanByCustomerId(@PathVariable(value = "customerId") String customerId) {
        return loanService.getLoansByCustomerId(customerId);
    }

    @GetMapping(value = Routes.GET_LOAN_BY_LOAN_ID)
    public Loan getLoanByLoanId(@PathVariable(value = "loanId") String loanId) {
        return loanService.getLoanById(loanId);
    }

    @GetMapping(value = Routes.GET_LOAN_BY_LENDER_ID)
    public List<Loan> getLoanByLenderId(@PathVariable(value = "lenderId") String leanderId) {
        return loanService.getLoansByLenderId(leanderId);
    }


}
