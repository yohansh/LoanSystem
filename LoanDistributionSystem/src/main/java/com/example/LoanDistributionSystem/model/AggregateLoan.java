package com.example.LoanDistributionSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class AggregateLoan {
        private String id;
        private BigDecimal remainingAmount;
        private BigDecimal interest;
        private BigDecimal penalty;
}
