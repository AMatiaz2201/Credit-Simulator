package com.example.credit.simulator.service.impl;

import com.example.credit.simulator.interfaces.json.request.LoanSimulationRequest;
import com.example.credit.simulator.interfaces.json.response.LoanSimulationResponse;
import com.example.credit.simulator.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoanServiceImpl implements LoanService {

  @Override
  public LoanSimulationResponse simulateLoan(LoanSimulationRequest loanSimulationRequest) {
    Integer pv = loanSimulationRequest.getLoanAmount();//Valor do emprestimo
    Integer n = loanSimulationRequest.getPaymentTerm();//Quantidade de messes a pagar

    log.info("Começando calculo da simulacao de R${} em {} messes", pv.toString(), n);

    double pmt;//Parcela mensal
    double r = loanSimulationRequest.getInterestRate() / 12;//Taxa de juros ao mes

    double dividend = pv * r;
    double divider = 1 - Math.pow(1 + r, -n);

    pmt = dividend / divider;

    LoanSimulationResponse loanSimulationResponse = LoanSimulationResponse.builder().build();
    loanSimulationResponse.setMonthlyInstallment(around(pmt));
    loanSimulationResponse.setTotalInterest(around((pmt * n) - pv));
    loanSimulationResponse.setTotalAmountPayable(around(pmt * n));

    log.info("Calculo finalizado, valor total: R${}",
        loanSimulationResponse.getTotalAmountPayable());

    return loanSimulationResponse;
  }

  private double around(double value) {
    return Math.round(value * 100.0) / 100.0;
  }
}
