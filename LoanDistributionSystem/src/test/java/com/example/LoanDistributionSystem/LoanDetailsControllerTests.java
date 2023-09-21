package com.example.LoanDistributionSystem;

import com.example.LoanDistributionSystem.controller.LoanDetailsController;
import com.example.LoanDistributionSystem.model.Loan;
import com.example.LoanDistributionSystem.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoanDetailsControllerTests {

    private MockMvc mockMvc;

    @Autowired
    LoanService loanService;

    @BeforeEach
    void setUp() {
        LoanService loanService = Mockito.mock(LoanService.class);
        LoanDetailsController controller = new LoanDetailsController();
        controller.setLoanService(loanService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetAllLoans() throws Exception {
        // Prepare sample data
        List<Loan> loanList = new ArrayList<>();
        loanList.add(new Loan("L1", "C1", "LEN1", 10000L, 10000L, LocalDate.parse("2023-05-06"), "1", LocalDate.parse("2023-05-07"), "0.01%", ""));
        loanList.add(new Loan("L2", "C1", "LEN1", 20000L, 5000L, LocalDate.parse("2023-01-06"), "1", LocalDate.parse("2023-05-08"), "0.01%", ""));
        Mockito.when(loanService.getAllLoans()).thenReturn(loanList);

        mockMvc.perform(get("/loans/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].loanID").value("L1"))
                .andExpect(jsonPath("$[1].loanID").value("L2"));
    }

    @Test
    public void testAddLoan() throws Exception {
        // Prepare a sample loan object
        Loan sampleLoan = new Loan("L1", "C1", "LEN1", 10000L, 10000L, LocalDate.parse("2023-05-06"), "1", LocalDate.parse("2023-05-07"), "0.01%", "");

        mockMvc.perform(post("/loans/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(sampleLoan)))
                .andExpect(status().isOk());

        Mockito.verify(loanService).addLoan(sampleLoan);
    }

}