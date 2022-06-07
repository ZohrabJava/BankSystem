package com.example.BankSystem.dto.IssuerDto;

import com.example.BankSystem.enams.BankType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IssuerRequestDto {
    private Long id;
    @NotBlank
    private String bankCode;
    @NotBlank
    private String bankName;
    @NotNull
    private BankType bankType;

    public IssuerRequestDto(Long id, String bankCode, String bankName, BankType bankType) {
        this.id = id;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankType = bankType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }
}
