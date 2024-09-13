package com.joaovictor.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.service.impl.PersonServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonServiceImpl personService;
    
    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.save(personDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

}
