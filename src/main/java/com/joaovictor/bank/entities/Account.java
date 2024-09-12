package com.joaovictor.bank.entities;

import com.joaovictor.bank.entities.enums.AccountType;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String digit;
    private String number;
    private Double balance;
    
    @NotNull(message = "Person is required")
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @NotNull(message = "Account type is required")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
