package com.example.BankSystem.service;

import com.example.BankSystem.dto.IssuerDto.IssuerRequestDto;
import com.example.BankSystem.model.Issuer;

public interface IssuerService {

    Issuer createIssuer(IssuerRequestDto createIssuerRequestDto);

    void deleteIssuer(Long id);

    Issuer updateIssuer(IssuerRequestDto updateIssuerRequestDto, Long id);

    Issuer getIssuerById(Long id);

}
