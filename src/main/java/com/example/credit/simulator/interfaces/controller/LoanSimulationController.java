package com.example.credit.simulator.interfaces.controller;

import com.example.credit.simulator.interfaces.json.request.LoanSimulationRequest;
import com.example.credit.simulator.interfaces.json.response.LoanSimulationResponse;
import com.example.credit.simulator.service.LoanSimulationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/loan/simulation")
@RequiredArgsConstructor
public class LoanSimulationController {

  private final LoanSimulationService loanService;

  @PostMapping
  public ResponseEntity<LoanSimulationResponse> postLoan(
      @Valid @RequestBody() LoanSimulationRequest loanSimulatorRequest
  ) {
    var response = loanService.simulateLoan(loanSimulatorRequest);
    return ResponseEntity.status(200).body(response);
  }
}
