package com.example.BankSystem.dto.CardDto;

import com.example.BankSystem.enams.CardStatus;
import com.example.BankSystem.enams.CardType;
import com.example.BankSystem.model.Issuer;

import java.time.LocalDate;

public class CardRequestDto {
    private Long id;

    private CardType cardType;

    private Issuer issuer;

    private Double balance;

    private String cardNumber;

    private LocalDate expirationDate;

    private String cvcCode;

    private CardStatus cardStatus;

    private String pin;

    public CardRequestDto(Long id, CardType cardType, Issuer issuer, Double balance, String cardNumber, LocalDate expirationDate, String cvcCode, CardStatus cardStatus, String pin) {
        this.id = id;
        this.cardType = cardType;
        this.issuer = issuer;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvcCode = cvcCode;
        this.cardStatus = cardStatus;
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(String cvcCode) {
        this.cvcCode = cvcCode;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
