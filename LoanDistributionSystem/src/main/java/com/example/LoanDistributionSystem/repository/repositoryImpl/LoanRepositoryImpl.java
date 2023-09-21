package com.example.LoanDistributionSystem.repository.repositoryImpl;

import com.example.LoanDistributionSystem.model.Loan;
import com.example.LoanDistributionSystem.repository.LoanRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class LoanRepositoryImpl implements LoanRepository {
    private final Map<String, Loan> loanMap = new ConcurrentHashMap<>();
    private final AtomicLong loanIdGenerator = new AtomicLong(1);

    @Override
    public Loan addLoan(Loan loan) {
        loan.setLoanID("L"+String.valueOf(loanIdGenerator.getAndIncrement()));
        loanMap.put(loan.getLoanID(), loan);
        return loan;
    }

    @Override
    public Loan getLoanById(String loanId) {
        return loanMap.get(loanId);
    }

    @Override
    public List<Loan> getAllLoans() {
        return new ArrayList<>(loanMap.values());
    }

    @Override
    public List<Loan> getLoansByCustomerId(String customerId) {
        return loanMap.values().stream()
                .filter(loan -> loan.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> getLoansByLenderId(String lenderId) {
        return loanMap.values().stream()
                .filter(loan -> loan.getLenderId().equals(lenderId))
                .collect(Collectors.toList());
    }


 //   @Override
//    public BigDecimal getRemainingAmountSumByLender(String lenderId) {
//        return loanMap.values().stream()
//                .filter(loan -> lenderId.equals(loan.getLenderId()))
//                .map(Loan::getRemainingAmount)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }

//    @Override
//    public BigDecimal getRemainingAmountSumByCustomerId(String customerId) {
//        return loanMap.values().stream()
//                .filter(loan -> customerId.equals(loan.getCustomerId()))
//                .map(Loan::getRemainingAmount)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }

//    @Override
//    public BigDecimal getRemainingAmountSumByInterest(String interest) {
//        return loanMap.values().stream()
//                .filter(loan -> interest.equals(loan.getInterestPerDay()))
//                .map(Loan::getRemainingAmount)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }
//    @Override
//    public void checkDueDatesAndLogAlerts() {
//        LocalDate currentDate = LocalDate.now();
//        for (Loan loan : loanMap.values()) {
//            if (loan.getDueDate().isBefore(currentDate)) {
//                log.error("Loan ID {} is overdue. Due Date: {}", loan.getLoanID(), loan.getDueDate());
//            }
//        }
//    }
}
