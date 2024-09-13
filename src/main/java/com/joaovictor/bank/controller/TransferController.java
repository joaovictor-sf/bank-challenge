package com.joaovictor.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovictor.bank.dto.TransferDTO;
import com.joaovictor.bank.service.impl.TransferServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {

    private final TransferServiceImpl transferService;

    @PostMapping
    public ResponseEntity<TransferDTO> create(@RequestBody TransferDTO transferDTO) {
        return ResponseEntity.ok(transferService.create(transferDTO));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(transferService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(transferService.findById(id));
    }

}
