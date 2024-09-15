package com.joaovictor.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovictor.bank.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
