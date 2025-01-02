package com.example.credit.simulator.interfaces.json.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
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


  @NotNull
  private Integer loanAmount;
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate birthDate;
  @NotNull
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
