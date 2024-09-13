package com.joaovictor.bank.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {
        
        private Long id;
        private Double value;
        private LocalDate date;
        private Long accountId;
        private Long destinationId;
}
