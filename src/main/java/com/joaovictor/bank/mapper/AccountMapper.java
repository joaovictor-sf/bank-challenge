package com.joaovictor.bank.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaovictor.bank.dto.AccountDTO;
import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.entities.Account;
import com.joaovictor.bank.entities.Person;
import com.joaovictor.bank.entities.enums.AccountType;
import com.joaovictor.bank.service.impl.PersonServiceImpl;

@Component
public class AccountMapper {

    private static PersonServiceImpl personService;

    @Autowired
    public void setPersonService(PersonServiceImpl personService) {
        AccountMapper.personService = personService;
    }

    public static AccountDTO toDTO(Account account) {
        return new AccountDTO(
            account.getId(),
            account.getDigit(),
            account.getNumber(),
            account.getBalance(),
            account.getPerson().getId(),
            account.getAccountType().name()
        );
    }

    public static Account toEntity(AccountDTO accountDTO) {

        PersonDTO personDTO = personService.findById(accountDTO.getPersonId());
        Person person = PersonMapper.toEntity(personDTO);
        AccountType accountType = AccountType.valueOf(accountDTO.getAccountType());

        return new Account(
            accountDTO.getId(),
            accountDTO.getDigit(),
            accountDTO.getNumber(),
            accountDTO.getBalance(),
            person,
            accountType
        );
    }

    public static List<AccountDTO> toDTOList(List<Account> accounts) {
        return accounts.stream().map(AccountMapper::toDTO).toList();
    }

}
