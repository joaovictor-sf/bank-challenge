package com.joaovictor.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.service.impl.PersonServiceImpl;

@Controller
public class PersonViewController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/")
    public String index(Model model) {
        List<PersonDTO> personsDTO = personService.findAll();
        model.addAttribute("persons", personsDTO);
        model.addAttribute("person", new PersonDTO());
        return "index";
    }

    @PostMapping("/addPerson")
    public String addPerson(@ModelAttribute PersonDTO person) {
        personService.save(person);
        return "redirect:/";
    }

}
