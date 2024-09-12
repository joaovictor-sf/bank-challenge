package com.joaovictor.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaovictor.bank.dto.AccountDTO;
import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.entities.Account;
import com.joaovictor.bank.exceptions.DuplicateAccountTypeException;
import com.joaovictor.bank.exceptions.MaxAccountNumberExcepetion;
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
        AccountDTO accountDTO2;
        int n = 0;

        List<AccountDTO> accounts = findAll();
        
        for (int i = 0; i < accounts.size(); i++) {
            accountDTO2 = accounts.get(i);
            if (accountDTO2.getPersonId().equals(accountDTO.getPersonId())) {
                n++;
                if (n == 2) {
                    throw new MaxAccountNumberExcepetion("The person already has two accounts");   
                }
                if (accountDTO2.getAccountType().equals(accountDTO.getAccountType())) {
                    throw new DuplicateAccountTypeException("The person already has an account of this type");
                }
            }
        }

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
