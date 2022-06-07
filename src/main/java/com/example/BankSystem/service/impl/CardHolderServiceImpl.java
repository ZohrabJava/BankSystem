package com.example.BankSystem.service.impl;

import com.example.BankSystem.convertor.CardHolderConvertor;
import com.example.BankSystem.dto.CaedHolderDto.CardHolderRequestDto;
import com.example.BankSystem.dto.CaedHolderDto.CardHolderResponseDto;
import com.example.BankSystem.dto.transferDto.TransferRequestDto;
import com.example.BankSystem.dto.transferDto.TransferResponseDto;
import com.example.BankSystem.enams.TransferState;
import com.example.BankSystem.model.CardHolder;
import com.example.BankSystem.repository.*;
import com.example.BankSystem.service.CardHolderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardHolderServiceImpl implements CardHolderService {
    private final CardHolderRepository cardHolderRepository;
    private final IssuerRepository issuerRepository;
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final AddressRepository addressRepository;
    private final CardHolderConvertor cardHolderConvertor;
    private final AccountServiceImpl accountService;
    private final CardServiceImpl cardService;
    private final AddressServiceImpl addressService;


    public CardHolderServiceImpl(CardHolderRepository cardHolderRepository, IssuerRepository issuerRepository,
                                 CardRepository cardRepository, AccountRepository accountRepository,
                                 AddressRepository addressRepository, CardHolderConvertor cardHolderConvertor,
                                 AccountServiceImpl accountService, CardServiceImpl cardService, AddressServiceImpl addressService) {
        this.cardHolderRepository = cardHolderRepository;
        this.issuerRepository = issuerRepository;
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
        this.cardHolderConvertor = cardHolderConvertor;
        this.accountService = accountService;
        this.cardService = cardService;
        this.addressService = addressService;
    }

    @Override
    public CardHolderResponseDto createCardHolder(CardHolderRequestDto creatCardHolderRequestDto) {
        var cardHolder = cardHolderRepository.save(convert(creatCardHolderRequestDto));
        var dto = cardHolderConvertor.convert(cardHolder);
        return dto;
    }

    @Override
    public CardHolderResponseDto updateCardHolder(CardHolderRequestDto updateCardHolderRequestDto, Long id) {
        CardHolder cardHolder = cardHolderRepository.getById(id);
        cardHolder.setCard(cardService.convert(updateCardHolderRequestDto.getCard()));
        cardHolder.setAccount(accountService.convert(updateCardHolderRequestDto.getAccount()));
        cardHolder.setAddress(addressService.convert(updateCardHolderRequestDto.getAddress()));
        cardHolderRepository.save(cardHolder);
        return new CardHolderConvertor().convert(updateCardHolderRequestDto);
    }

    @Override
    public void deleteCardHolder(Long id) {
        cardHolderRepository.delete(cardHolderRepository.getById(id));
    }

    @Override
    public CardHolderResponseDto findCardHolderById(Long id) {
        CardHolder cardHolder = cardHolderRepository.getById(id);
        return new CardHolderConvertor().convert(cardHolder);
    }

    @Override
    public TransferResponseDto transferToCard(TransferRequestDto transferRequestDto) {
        TransferResponseDto responseDto = new TransferResponseDto();
        var fromCard = cardRepository.findByCardNumber(transferRequestDto.getFromCardNumber());
        var toCard = cardRepository.findByCardNumber(transferRequestDto.getToCardNumber());
        if (!fromCard.isEmpty() && !toCard.isEmpty()) {
            if (fromCard.get(0).getBalance() - transferRequestDto.getAmount() > 0) {
                fromCard.get(0).setBalance(fromCard.get(0).getBalance() - transferRequestDto.getAmount());
                cardRepository.save(fromCard.get(0));
                toCard.get(0).setBalance(toCard.get(0).getBalance() + transferRequestDto.getAmount());
                cardRepository.save(toCard.get(0));
                responseDto.setTransferFromCard(transferRequestDto.getFromCardNumber());
                responseDto.setAmount(transferRequestDto.getAmount());
                responseDto.setBalance(fromCard.get(0).getBalance());
                responseDto.setTransferState(TransferState.Transferred);
            } else {
                responseDto.setTransferFromCard(transferRequestDto.getFromCardNumber());
                responseDto.setAmount(transferRequestDto.getAmount());
                responseDto.setBalance(fromCard.get(0).getBalance());
                responseDto.setTransferState(TransferState.NotEnoughFound);
            }
            responseDto.setLocalDateTime(LocalDateTime.now());
            return responseDto;
        }
        responseDto.setTransferFromCard(transferRequestDto.getFromCardNumber());
        responseDto.setAmount(transferRequestDto.getAmount());
        responseDto.setBalance(0.00);
        responseDto.setTransferState(TransferState.CardNotFound);
        responseDto.setLocalDateTime(LocalDateTime.now());
        return responseDto;

    }

    @Override
    public TransferResponseDto transferToAccount(TransferRequestDto transferRequestDto) {
        TransferResponseDto responseDto = new TransferResponseDto();
        var fromCard = cardRepository.findByCardNumber(transferRequestDto.getFromCardNumber());
        var toAccount = accountRepository.findByIban(transferRequestDto.getIBAN());
        if (!fromCard.isEmpty() || !toAccount.isEmpty()) {
            if (fromCard.get(0).getBalance() - transferRequestDto.getAmount() > 0) {
                fromCard.get(0).setBalance(fromCard.get(0).getBalance() - transferRequestDto.getAmount());
                cardRepository.save(fromCard.get(0));
                toAccount.get(0).setAccountBalance(toAccount.get(0).getAccountBalance() + transferRequestDto.getAmount());
                accountRepository.save(toAccount.get(0));
                responseDto.setTransferFromCard(transferRequestDto.getFromCardNumber());
                responseDto.setAmount(transferRequestDto.getAmount());
                responseDto.setBalance(fromCard.get(0).getBalance());
                responseDto.setTransferState(TransferState.Transferred);
            } else {
                responseDto.setTransferFromCard(transferRequestDto.getFromCardNumber());
                responseDto.setAmount(transferRequestDto.getAmount());
                responseDto.setBalance(fromCard.get(0).getBalance());
                responseDto.setTransferState(TransferState.NotEnoughFound);
            }
            responseDto.setLocalDateTime(LocalDateTime.now());
            return responseDto;
        }
        responseDto.setTransferFromCard(transferRequestDto.getFromCardNumber());
        responseDto.setAmount(transferRequestDto.getAmount());
        responseDto.setBalance(0.00);
        responseDto.setTransferState(TransferState.AccountNotFound);
        responseDto.setLocalDateTime(LocalDateTime.now());
        return responseDto;
    }

    public CardHolder convert(CardHolderRequestDto cardHolderRequestDto) {
        CardHolder cardHolder = new CardHolder();
        var cardOptional = cardRepository.findByCardNumber(cardHolderRequestDto.getCard().getCardNumber());
        if (!cardOptional.isEmpty()) {
            cardHolder.setCard(cardOptional.get(0));
        } else {
            cardService.createCard(cardHolderRequestDto.getCard());
            cardOptional = cardRepository.findByCardNumber(cardHolderRequestDto.getCard().getCardNumber());
            cardHolder.setCard(cardOptional.get(0));
        }
        var accountOptional = accountRepository.findByIban(cardHolderRequestDto.getAccount().getIban());
        if (!accountOptional.isEmpty()) {
            cardHolder.setAccount(accountOptional.get(0));
        } else {
            accountOptional = accountRepository.findByIban(
                    accountService.createAccount(cardHolderRequestDto.getAccount()).getIban());
            cardHolder.setAccount(accountOptional.get(0));
        }
        var addressOptional = addressRepository.findByCityAndHouseNumberAndStateAndStreetAddressAndZipCode(
                cardHolderRequestDto.getAddress().getCity(),
                cardHolderRequestDto.getAddress().getHouseNumber(),
                cardHolderRequestDto.getAddress().getState(),
                cardHolderRequestDto.getAddress().getStreetAddress(),
                cardHolderRequestDto.getAddress().getZipCode());
        if (!addressOptional.isEmpty()) {
            cardHolder.setAddress(addressOptional.get(0));
        } else {
            addressService.createAddress(cardHolderRequestDto.getAddress());
            addressOptional = addressRepository.findByCityAndHouseNumberAndStateAndStreetAddressAndZipCode(
                    cardHolderRequestDto.getAddress().getCity(),
                    cardHolderRequestDto.getAddress().getHouseNumber(),
                    cardHolderRequestDto.getAddress().getState(),
                    cardHolderRequestDto.getAddress().getStreetAddress(),
                    cardHolderRequestDto.getAddress().getZipCode());
            cardHolder.setAddress(addressOptional.get(0));
        }
        return cardHolder;
    }
}
