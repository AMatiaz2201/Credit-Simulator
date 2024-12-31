package com.example.credit.simulator.interfaces.json.request;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LoanSimulationRequest {


  @NotBlank(message = "loanAmount is required")
  private Integer loanAmount;
  @NotBlank(message = "birthDate is required")
  private LocalDate birthDate;
  @NotBlank(message = "paymentTerm is required")
  private Integer paymentTerm;

  public double getInterestRate() {
    LocalDate today = LocalDate.now();
    double age = Period.between(birthDate, today).getYears();

    return
        (age <= 25) ? 0.05 :
            (age <= 40) ? 0.03 :
                (age <= 60) ? 0.02 : 0.04;

  }

}
