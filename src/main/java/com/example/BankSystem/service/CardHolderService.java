package com.example.BankSystem.service;

import com.example.BankSystem.dto.CaedHolderDto.CardHolderRequestDto;
import com.example.BankSystem.dto.CaedHolderDto.CardHolderResponseDto;
import com.example.BankSystem.dto.transferDto.TransferRequestDto;
import com.example.BankSystem.dto.transferDto.TransferResponseDto;

public interface CardHolderService {
    CardHolderResponseDto createCardHolder(CardHolderRequestDto creatCardHolderRequestDto);

    CardHolderResponseDto updateCardHolder(CardHolderRequestDto updateCardHolderRequestDto, Long id);

    void deleteCardHolder(Long id);

    CardHolderResponseDto findCardHolderById(Long id);

    TransferResponseDto transferToCard(TransferRequestDto transferRequestDto);

    TransferResponseDto transferToAccount(TransferRequestDto transferRequestDto);

}
