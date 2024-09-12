package com.joaovictor.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaovictor.bank.dto.AccountDTO;
import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.entities.Account;
import com.joaovictor.bank.mapper.AccountMapper;
import com.joaovictor.bank.mapper.PersonMapper;
import com.joaovictor.bank.repositories.AccountRepository;
import com.joaovictor.bank.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    
    private AccountRepository accountRepository;
    //private PersonServiceImpl personService;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        Account account = AccountMapper.toEntity(accountDTO);
        accountRepository.save(account);

        return AccountMapper.toDTO(account);
    }

    @Override
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return AccountMapper.toDTOList(accounts);
    }

    @Override
    public AccountDTO findById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow();
        return AccountMapper.toDTO(account);
    }

}
