package com.example.credit.simulator.service;

import com.example.credit.simulator.interfaces.json.request.LoanSimulationRequest;
import com.example.credit.simulator.interfaces.json.response.LoanSimulationResponse;

public interface LoanSimulationService {
  LoanSimulationResponse simulateLoan(LoanSimulationRequest loanSimulationRequest);
}
