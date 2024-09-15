package com.joaovictor.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaovictor.bank.dto.AccountDTO;
import com.joaovictor.bank.entities.Account;
import com.joaovictor.bank.exceptions.DuplicateAccountTypeException;
import com.joaovictor.bank.exceptions.MaxAccountNumberExcepetion;
import com.joaovictor.bank.exceptions.ResourceNotFoundException;
import com.joaovictor.bank.mapper.AccountMapper;
import com.joaovictor.bank.repositories.AccountRepository;
import com.joaovictor.bank.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    
    private AccountRepository accountRepository;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        accountDTO.setBalance(0.0);
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
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        return AccountMapper.toDTO(account);
    }

    @Override
    public Double deposit(Long id, Double value) {
        AccountDTO account = findById(id);

        if (value <= 0) throw new IllegalArgumentException("The value must be greater than zero");
        
        account.setBalance(account.getBalance() + value);
        accountRepository.save(AccountMapper.toEntity(account));

        return account.getBalance();
    }

    @Override
    public Double withdraw(Long id, Double value) {
        AccountDTO account = findById(id);

        if (value <= 0) throw new IllegalArgumentException("The value must be greater than zero");
        if (account.getBalance() < value) throw new IllegalArgumentException("Insufficient balance");

        account.setBalance(account.getBalance() - value);
        accountRepository.save(AccountMapper.toEntity(account));

        return account.getBalance();
    }

    @Override
    public Double getBalance(Long id) {
        AccountDTO account = findById(id);
        return account.getBalance();
    }

    @Override
    public void transfer(Long id, Long destinationId, Double value) {
        if (id.equals(destinationId)) throw new IllegalArgumentException("The account and the destination account must be different");
        
        AccountDTO account = findById(id);
        AccountDTO destination = findById(destinationId);

        if (value <= 0) throw new IllegalArgumentException("The value must be greater than zero");
        if (account.getBalance() < value) throw new IllegalArgumentException("Insufficient balance");

        account.setBalance(account.getBalance() - value);
        destination.setBalance(destination.getBalance() + value);

        Account origin = AccountMapper.toEntity(account);
        Account dest = AccountMapper.toEntity(destination);

        accountRepository.save(origin);
        accountRepository.save(dest);
    }

}
