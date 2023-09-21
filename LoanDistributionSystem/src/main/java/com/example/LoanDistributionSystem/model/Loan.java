package com.example.LoanDistributionSystem.model;

import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    private String loanID;
    private String customerId;
    private String lenderId;
    private long amount;
    private long remainingAmount;
    private LocalDate paymentDate;
    private String interestPerDay;
    private LocalDate dueDate;
    private String penaltyPercentage;
    private String cancel;
}

