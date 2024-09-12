package com.joaovictor.bank.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
}
