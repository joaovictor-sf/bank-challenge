package com.joaovictor.bank.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "transfer")
public class Transfer {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private LocalDate date;
    
    @NotNull(message = "Account is required")
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @NotNull(message = "Destination account is required")
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Account destinationAccount;
}
