package com.example.BankSystem.repository;

import com.example.BankSystem.model.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssuerRepository extends JpaRepository<Issuer, Long> {
    List<Issuer> findByBankCodeAndBankName(String bankCode,String bankName);
}
