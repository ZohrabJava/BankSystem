package com.example.BankSystem.dto.CaedHolderDto;

import com.example.BankSystem.dto.AccountDto.AccountResponseDto;
import com.example.BankSystem.dto.AddressDto.AddressResponseDto;
import com.example.BankSystem.dto.CardDto.CardResponseDto;

public class CardHolderResponseDto {
    private Long cardHolderId;
    private CardResponseDto card;
    private AccountResponseDto account;
    private AddressResponseDto address;

    public CardHolderResponseDto(Long cardHolderId, CardResponseDto card, AccountResponseDto account, AddressResponseDto address) {
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

    public CardResponseDto getCard() {
        return card;
    }

    public void setCard(CardResponseDto card) {
        this.card = card;
    }

    public AccountResponseDto getAccount() {
        return account;
    }

    public void setAccount(AccountResponseDto account) {
        this.account = account;
    }

    public AddressResponseDto getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDto address) {
        this.address = address;
    }
}
