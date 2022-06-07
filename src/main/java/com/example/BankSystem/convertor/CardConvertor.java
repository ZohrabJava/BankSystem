package com.example.BankSystem.convertor;

import com.example.BankSystem.dto.CardDto.CardRequestDto;
import com.example.BankSystem.dto.CardDto.CardResponseDto;
import com.example.BankSystem.model.Card;
import com.example.BankSystem.model.Issuer;
import org.springframework.stereotype.Component;

@Component
public class CardConvertor {
    public CardResponseDto convert(CardRequestDto card){
        return new CardResponseDto(card.getId(),card.getCardType(),new Issuer( card.getIssuer().getId(), card.getIssuer().getBankCode(),
                card.getIssuer().getBankName(),card.getIssuer().getBankType()),card.getBalance(),
                card.getCardNumber(),card.getExpirationDate(),card.getCvcCode(),card.getCardStatus(),card.getPin());
    }
    public CardResponseDto convert(Card card){
        return new CardResponseDto(card.getId(),card.getCardType(),new Issuer( card.getIssuer().getId(), card.getIssuer().getBankCode(),
                card.getIssuer().getBankName(),card.getIssuer().getBankType()),card.getBalance(),
                card.getCardNumber(),card.getExpirationDate(),card.getCvcCode(),card.getCardStatus(),card.getPin());
    }
}
