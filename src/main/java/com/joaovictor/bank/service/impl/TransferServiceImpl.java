package com.joaovictor.bank.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.joaovictor.bank.dto.TransferDTO;
import com.joaovictor.bank.entities.Transfer;
import com.joaovictor.bank.exceptions.ResourceNotFoundException;
import com.joaovictor.bank.mapper.TransferMapper;
import com.joaovictor.bank.repositories.TransferRepository;
import com.joaovictor.bank.service.TransferService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferServiceImpl implements TransferService{

    private TransferRepository transferRepository;
    private AccountServiceImpl accountService;

    @Override
    public TransferDTO create(TransferDTO transferDTO) {
        accountService.transfer(transferDTO.getAccountId(), transferDTO.getDestinationId(), transferDTO.getValue());

        LocalDate date = LocalDate.now();
        transferDTO.setDate(date);
        Transfer transfer = TransferMapper.toEntity(transferDTO);

        //LocalDate date = LocalDate.now();
        //transfer.setDate(date);

        transfer = transferRepository.save(transfer);
        return TransferMapper.toDTO(transfer);
    }

    @Override
    public List<TransferDTO> findAll() {
        List<Transfer> transfers = transferRepository.findAll();
        return TransferMapper.toDTOList(transfers);
    }

    @Override
    public TransferDTO findById(Long id) {
        Transfer transfer = transferRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transfer not found"));
        return TransferMapper.toDTO(transfer);
    }

}
