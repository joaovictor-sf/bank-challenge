package com.joaovictor.bank.service;

import java.util.List;

import com.joaovictor.bank.dto.PersonDTO;

public interface PersonService {
    PersonDTO save(PersonDTO personDTO);
    List<PersonDTO> findAll();
    PersonDTO findById(Long id);
}
