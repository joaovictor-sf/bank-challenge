package com.joaovictor.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joaovictor.bank.dto.TransferDTO;
import com.joaovictor.bank.service.impl.TransferServiceImpl;

@Controller
public class TransferViewController {

    @Autowired
    private TransferServiceImpl transferService;

    @GetMapping("/transfers")
    public String listTransfers(Model model) {
        List<TransferDTO> transfers = transferService.findAll();
        model.addAttribute("transfers", transfers);
        model.addAttribute("transfer", new TransferDTO());
        return "transfers";
    }

    @PostMapping("/addTransfer")
    public String addTransfer(TransferDTO transfer) {
        transferService.create(transfer);
        return "redirect:/transfers";
    }

}
