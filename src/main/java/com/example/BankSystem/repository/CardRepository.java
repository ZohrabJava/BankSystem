package com.example.BankSystem.repository;

import com.example.BankSystem.model.Card;
import com.example.BankSystem.model.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {
    List<Card> findByCardNumber(String cardNumber);
}

