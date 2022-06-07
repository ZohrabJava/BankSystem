package com.example.BankSystem.model;

import com.example.BankSystem.enams.CardStatus;
import com.example.BankSystem.enams.CardType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "card")
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;
    @Column(name = "card_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    @JoinColumn(name = "issuer_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Issuer issuer;
    @Column(name = "balance",nullable = false)
    private Double balance;
    @Column(name = "card_number",nullable = false,unique = true)
    private String cardNumber;
    @Column(name = "expiration_date",nullable = false)
    private LocalDate expirationDate;
    @Column(name = "cvc",nullable = false)
    private String cvcCode;
    @Column(name = "card_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;
    @Column(name = "pin",nullable = false)
    private String pin;

//    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
//    private Set<CardHolder> cardHolders;
    public Card(Long id, CardType cardType, Issuer issuer, Double balance, String cardNumber, LocalDate expirationDate, String cvcCode, CardStatus cardStatus, String pin) {
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
    public Card(){

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
