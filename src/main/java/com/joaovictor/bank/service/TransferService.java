package com.joaovictor.bank.service;

import java.util.List;

import com.joaovictor.bank.dto.TransferDTO;

public interface TransferService {
    
        TransferDTO create(TransferDTO transferDTO);
        List<TransferDTO> findAll();
        TransferDTO findById(Long id);
}
