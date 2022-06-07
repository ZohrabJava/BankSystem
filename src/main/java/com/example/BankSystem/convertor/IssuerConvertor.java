package com.example.BankSystem.convertor;

import com.example.BankSystem.dto.IssuerDto.IssuerRequestDto;
import com.example.BankSystem.dto.IssuerDto.IssuerResponseDto;
import com.example.BankSystem.model.Issuer;
import org.springframework.stereotype.Component;

@Component
public class IssuerConvertor {
    public IssuerResponseDto convert(Issuer issuer){
        return new IssuerResponseDto(issuer.getId(),issuer.getBankCode(),
                issuer.getBankName(),issuer.getBankType());
    }
    public IssuerResponseDto convert(IssuerRequestDto issuer){
        return new IssuerResponseDto(issuer.getId(),issuer.getBankCode(),
                issuer.getBankName(),issuer.getBankType());
    }
}
