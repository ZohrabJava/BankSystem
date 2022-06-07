package com.example.BankSystem.dto.CaedHolderDto;

import com.example.BankSystem.dto.AccountDto.AccountRequestDto;
import com.example.BankSystem.dto.AddressDto.AddressRequestDto;
import com.example.BankSystem.dto.CardDto.CardRequestDto;

public class CardHolderRequestDto {
    private Long cardHolderId;
    private CardRequestDto card;
    private AccountRequestDto account;
    private AddressRequestDto address;

    public CardHolderRequestDto(Long cardHolderId, CardRequestDto card, AccountRequestDto account, AddressRequestDto address) {
        this.cardHolderId = cardHolderId;
        this.card = card;
        this.account = account;
        this.address = address;
    }

    public Long getCardHolderId() {
        return cardHolderId;
    }

    public void setCardHolderId(Long cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public CardRequestDto getCard() {
        return card;
    }

    public void setCard(CardRequestDto card) {
        this.card = card;
    }

    public AccountRequestDto getAccount() {
        return account;
    }

    public void setAccount(AccountRequestDto account) {
        this.account = account;
    }

    public AddressRequestDto getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDto address) {
        this.address = address;
    }
}
