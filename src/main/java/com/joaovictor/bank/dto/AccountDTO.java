package com.joaovictor.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String digit;
    private String number;
    private Double balance;
    //private PersonDTO person;
    private Long personId;
    private String accountType;//SAVINGS, CHECKING
}
