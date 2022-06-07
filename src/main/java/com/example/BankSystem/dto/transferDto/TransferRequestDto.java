package com.example.BankSystem.dto.transferDto;

import com.example.BankSystem.enams.TransferState;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class TransferRequestDto {
    @NotNull
    private Double amount;
    @NotBlank
    private String fromCardNumber;
    private String toCardNumber;
    private String IBAN;

    private TransferState transferState;
    public TransferRequestDto(Double amount, String fromCardNumber, String toCardNumber, String IBAN) {
        this.amount = amount;
        this.fromCardNumber = fromCardNumber;
        this.toCardNumber = toCardNumber;
        this.IBAN = IBAN;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getFromCardNumber() {
        return fromCardNumber;
    }

    public void setFromCardNumber(String fromCardNumber) {
        this.fromCardNumber = fromCardNumber;
    }

    public String getToCardNumber() {
        return toCardNumber;
    }

    public void setToCardNumber(String toCardNumber) {
        this.toCardNumber = toCardNumber;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}
