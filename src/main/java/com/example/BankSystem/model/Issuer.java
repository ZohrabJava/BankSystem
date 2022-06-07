package com.example.BankSystem.model;

import com.example.BankSystem.enams.BankType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "issuer",uniqueConstraints = { @UniqueConstraint(columnNames = { "bank_code", "bank_name" })})
public class Issuer implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "issuer_id",nullable = false)
    private Long id;
    @Column(name = "bank_code",nullable = false)
    private String bankCode;
    @Column(name = "bank_name",nullable = false)
    private String bankName;
    @Column(name = "bank_Type",nullable = false)
    @Enumerated(EnumType.STRING)
    private BankType bankType;

    public Issuer(Long id, String bankCode, String bankName, BankType bankType) {
        this.id = id;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankType = bankType;
    }

    public Issuer() {

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
