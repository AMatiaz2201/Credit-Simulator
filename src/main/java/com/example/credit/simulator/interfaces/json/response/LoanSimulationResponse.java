package com.example.credit.simulator.interfaces.json.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoanSimulationResponse {

  private Double totalAmountPayable;
  private Double monthlyInstallment;
  private Double totalInterest;

}
