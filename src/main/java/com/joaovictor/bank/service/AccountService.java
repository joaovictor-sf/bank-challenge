package com.joaovictor.bank.service;

import java.util.List;

import com.joaovictor.bank.dto.AccountDTO;

public interface AccountService {

    AccountDTO create(AccountDTO accountDTO);
    List<AccountDTO> findAll();
    AccountDTO findById(Long id);
    
    Double deposit(Long id, Double value);
    Double withdraw(Long id, Double value);

    Double getBalance(Long id);

    void transfer(Long id, Long destinationId, Double value);

}
