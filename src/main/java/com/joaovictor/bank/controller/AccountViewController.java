package com.joaovictor.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joaovictor.bank.dto.AccountDTO;
import com.joaovictor.bank.dto.PersonDTO;
import com.joaovictor.bank.entities.Account;
import com.joaovictor.bank.service.impl.AccountServiceImpl;

@Controller
public class AccountViewController {
    
    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        List<AccountDTO> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        model.addAttribute("account", new AccountDTO());
        return "accounts";
    }

    @PostMapping("/addAccount")
    public String addAccount(@ModelAttribute AccountDTO account) {
        accountService.create(account);
        return "redirect:/accounts";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam("amount") Double amount, @RequestParam("id") Long id) {
        accountService.deposit(id, amount);
        return "redirect:/accounts";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("amount") Double amount, @RequestParam("id") Long id) {
        accountService.withdraw(id, amount);
        return "redirect:/accounts";
    }

    @GetMapping("/balance")
    public String balance(@RequestParam("id") Long id, Model model) {
        Double balance = accountService.getBalance(id);
        AccountDTO account = accountService.findById(id);
        model.addAttribute("account", account);
        model.addAttribute("balance", balance);
        return "accounts";
    }
}
