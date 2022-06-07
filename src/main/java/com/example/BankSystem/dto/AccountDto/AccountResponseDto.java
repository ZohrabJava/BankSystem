package com.example.BankSystem.dto.AccountDto;

import com.example.BankSystem.model.Issuer;

public class AccountResponseDto {
    private Long id;

    private String iban;


    private Issuer issuer;

    private Double accountBalance;

    public AccountResponseDto(Long id, String iban, Issuer issuer, Double accountBalance) {
        this.id = id;
        this.iban = iban;
        this.issuer = issuer;
        this.accountBalance = accountBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
