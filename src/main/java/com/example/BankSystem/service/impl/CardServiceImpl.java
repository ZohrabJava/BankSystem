package com.example.BankSystem.service.impl;

import com.example.BankSystem.dto.CardDto.CardRequestDto;
import com.example.BankSystem.model.Card;
import com.example.BankSystem.model.Issuer;
import com.example.BankSystem.repository.CardRepository;
import com.example.BankSystem.repository.IssuerRepository;
import com.example.BankSystem.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.BankSystem.enams.CardStatus.ACTIVE;
import static com.example.BankSystem.enams.CardStatus.BLOCKED;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final IssuerRepository issuerRepository;

    public CardServiceImpl(CardRepository cardRepository,IssuerRepository issuerRepository) {
        this.cardRepository = cardRepository;
        this.issuerRepository=issuerRepository;
    }

    @Override
    public Card createCard(CardRequestDto creatCardRequestDto) {
        List<Issuer> issuerOptional=issuerRepository.findByBankCodeAndBankName(
                creatCardRequestDto.getIssuer().getBankCode(),creatCardRequestDto.getIssuer().getBankName());
        if (!issuerOptional.isEmpty()){
            creatCardRequestDto.setIssuer(issuerOptional.get(0));
        }
        return cardRepository.save(convert(creatCardRequestDto));
    }

    @Override
    public Card activateCard(Long id) {
        Card card = cardRepository.getById(id);
        card.setCardStatus(ACTIVE);
        return cardRepository.save(card);
    }

    @Override
    public Card blockCard(Long id) {
        Card card = cardRepository.getById(id);
        card.setCardStatus(BLOCKED);
        return cardRepository.save(card);
    }

    @Override
    public Card findCardById(Long id) {
        return cardRepository.getById(id);
    }

    public Card convert(CardRequestDto cardRequestDto) {
        Card card = new Card();
        card.setCardNumber(cardRequestDto.getCardNumber());
        card.setBalance(cardRequestDto.getBalance());
        card.setCardStatus(cardRequestDto.getCardStatus());
        card.setCardType(cardRequestDto.getCardType());
        card.setCvcCode(cardRequestDto.getCvcCode());
        card.setExpirationDate(cardRequestDto.getExpirationDate());
        card.setPin(cardRequestDto.getPin());
        List<Issuer> issuerOptional=issuerRepository.findByBankCodeAndBankName(cardRequestDto.getIssuer().getBankCode(),cardRequestDto.getIssuer().getBankName());
        if (!issuerOptional.isEmpty()){
            cardRequestDto.setIssuer(issuerOptional.get(0));
        }
        card.setIssuer(cardRequestDto.getIssuer());
        return card;
    }
}
