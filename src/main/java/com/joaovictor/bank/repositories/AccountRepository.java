package com.joaovictor.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovictor.bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
