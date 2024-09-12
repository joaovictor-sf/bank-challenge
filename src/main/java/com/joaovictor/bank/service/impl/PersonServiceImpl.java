package com.joaovictor.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.entities.Person;
import com.joaovictor.bank.exceptions.ResourceNotFoundException;
import com.joaovictor.bank.mapper.PersonMapper;
import com.joaovictor.bank.repositories.PersonRepository;
import com.joaovictor.bank.service.PersonService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;
    
    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return PersonMapper.toDTO(person);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> people = personRepository.findAll();
        return PersonMapper.toDTOList(people);
    }

    @Override
    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        return PersonMapper.toDTO(person);
    }

}
