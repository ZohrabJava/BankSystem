package com.example.BankSystem.dto.AccountDto;

import com.example.BankSystem.model.Issuer;

public class AccountRequestDto {
    private Long id;

    private String iban;

    private Issuer issuerDto;

    private Double accountBalance;

    public AccountRequestDto(Long id, String iban, Issuer issuerDt, Double accountBalance) {
        this.id = id;
        this.iban = iban;
        this.issuerDto = issuerDt;
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
        return issuerDto;
    }

    public void setIssuer(Issuer issuer) {
        this.issuerDto = issuer;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
