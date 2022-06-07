package com.example.BankSystem.repository;

import com.example.BankSystem.model.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHolderRepository extends JpaRepository<CardHolder,Long> {
}
