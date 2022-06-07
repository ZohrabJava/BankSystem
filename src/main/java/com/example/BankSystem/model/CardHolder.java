package com.example.BankSystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "card_Holder",uniqueConstraints = { @UniqueConstraint(columnNames = { "card_id", "account_id","address_id" }) })
public class CardHolder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardHolderId;
    @JoinColumn(name = "card_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Card card;
    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Account account;
    @JoinColumn(name = "address_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Address address;

    public CardHolder(Long cardHolderId, Card card, Account account, Address address) {
        this.cardHolderId = cardHolderId;
        this.card = card;
        this.account = account;
        this.address = address;
    }
    public CardHolder(){

    }

    public Long getCardHolderId() {
        return cardHolderId;
    }

    public void setCardHolderId(Long cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
