package com.example.BankSystem.repository;

import com.example.BankSystem.model.Account;
import com.example.BankSystem.model.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByIban(String iban);
}
