package com.joaovictor.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovictor.bank.dto.AccountDTO;
import com.joaovictor.bank.service.impl.AccountServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping
    public ResponseEntity<AccountDTO> create(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountService.create(accountDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(accountService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

}
