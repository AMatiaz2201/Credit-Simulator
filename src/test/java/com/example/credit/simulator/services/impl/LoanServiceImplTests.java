package com.example.credit.simulator.services.impl;


import com.example.credit.simulator.interfaces.json.request.LoanSimulationRequest;
import com.example.credit.simulator.service.impl.LoanServiceImpl;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoanServiceImplTests {

  @InjectMocks
  private LoanServiceImpl loanService;

  @Test
  @DisplayName("Simulation loan with success")
  public void simulationLoanWithSuccess() {
    LoanSimulationRequest loanSimulationRequest = LoanSimulationRequest.builder()
        .loanAmount(1000)
        .birthDate(LocalDate.of(1997, 1, 22))
        .paymentTerm(24)
        .build();

    var response = loanService.simulateLoan(loanSimulationRequest);

    Assertions.assertEquals(42.98, response.getMonthlyInstallment());
    Assertions.assertEquals(1031.55, response.getTotalAmountPayable());
    Assertions.assertEquals(31.55, response.getTotalInterest());
  }

  @Test
  @DisplayName("Simulation loan with error because loanAmount is null")
  public void simulationLoanWithErrorBecauseLoanAmountIsNull() {
    LoanSimulationRequest loanSimulationRequest = LoanSimulationRequest.builder()
        .birthDate(LocalDate.of(1997, 1, 22))
        .paymentTerm(24)
        .build();

    Assertions.assertThrows(NullPointerException.class,
        () -> loanService.simulateLoan(loanSimulationRequest));

  }
}
