package com.example.BankSystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    @Column(name = "iban",nullable = false,unique = true)
    private String iban;
    @JoinColumn(name = "issuer_id",nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
//    @JsonManagedReference
    private Issuer issuer;
    @Column(name = "account_balance")
    private Double accountBalance;

//    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
//    private Set<CardHolder> cardHolders;
    public Account(Long id, String iban, Issuer issuer, Double accountBalance) {
        this.id = id;
        this.iban = iban;
        this.issuer = issuer;
        this.accountBalance = accountBalance;
    }

    public Account(){

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
