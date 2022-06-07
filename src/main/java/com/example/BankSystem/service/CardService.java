package com.example.BankSystem.service;

import com.example.BankSystem.dto.CardDto.CardRequestDto;
import com.example.BankSystem.model.Card;

public interface CardService {
    Card createCard(CardRequestDto creatCardRequestDto);

    Card activateCard(Long id);

    Card blockCard(Long id);

    Card findCardById(Long id);

}
