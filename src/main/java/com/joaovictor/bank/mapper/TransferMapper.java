package com.joaovictor.bank.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaovictor.bank.dto.TransferDTO;
import com.joaovictor.bank.entities.Transfer;
import com.joaovictor.bank.service.impl.AccountServiceImpl;

@Component
public class TransferMapper {

    private static AccountServiceImpl accountService;

    public TransferMapper(AccountServiceImpl accountService) {
        TransferMapper.accountService = accountService;
    }

    public static TransferDTO toDTO(Transfer transfer) {
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setId(transfer.getId());
        transferDTO.setValue(transfer.getValue());
        transferDTO.setDate(transfer.getDate());
        transferDTO.setAccountId(transfer.getAccount().getId());
        transferDTO.setDestinationId(transfer.getDestinationAccount().getId());
        return transferDTO;
    }

    public static Transfer toEntity(TransferDTO transferDTO) {
        Transfer transfer = new Transfer();
        transfer.setId(transferDTO.getId());
        transfer.setValue(transferDTO.getValue());
        transfer.setDate(transferDTO.getDate());
        
        transfer.setAccount(AccountMapper.toEntity(accountService.findById(transferDTO.getAccountId())));
        transfer.setDestinationAccount(AccountMapper.toEntity(accountService.findById(transferDTO.getDestinationId())));

        return transfer;
    }

    public static List<TransferDTO> toDTOList(List<Transfer> transfers) {
        return transfers.stream().map(transfer -> toDTO(transfer)).toList();
    }
}
