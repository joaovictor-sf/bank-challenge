package com.joaovictor.bank.mapper;

import java.util.List;

import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.entities.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person person) {
        return new PersonDTO(person.getId(), person.getName(), person.getCpf(), person.getPhone());
    }

    public static Person toEntity(PersonDTO personDTO) {
        return new Person(personDTO.getId(), personDTO.getName(), personDTO.getCpf(), personDTO.getPhone());
    }

    public static List<PersonDTO> toDTOList(List<Person> people) {
        return people.stream().map(PersonMapper::toDTO).toList();
    }
}
