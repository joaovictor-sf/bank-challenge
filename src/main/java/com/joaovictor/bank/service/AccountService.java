package com.joaovictor.bank.service;

import java.util.List;

import com.joaovictor.bank.dto.AccountDTO;
import com.joaovictor.bank.dto.PersonDTO;

public interface AccountService {

    AccountDTO create(AccountDTO accountDTO);
    List<AccountDTO> findAll();
    AccountDTO findById(Long id);

}
