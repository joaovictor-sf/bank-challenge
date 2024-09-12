package com.joaovictor.bank.entities;

import com.joaovictor.bank.entities.enums.AccountType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String digit;
    private String number;
    private Double balance;
    
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
