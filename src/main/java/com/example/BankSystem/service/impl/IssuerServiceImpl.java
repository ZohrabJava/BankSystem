package com.example.BankSystem.service.impl;

import com.example.BankSystem.dto.IssuerDto.IssuerRequestDto;
import com.example.BankSystem.model.Issuer;
import com.example.BankSystem.repository.IssuerRepository;
import com.example.BankSystem.service.IssuerService;
import org.springframework.stereotype.Service;

@Service
public class IssuerServiceImpl implements IssuerService {
    private final IssuerRepository issuerRepository;

    public IssuerServiceImpl(IssuerRepository issuerRepository) {
        this.issuerRepository=issuerRepository;
    }

    @Override
    public Issuer createIssuer(IssuerRequestDto createIssuerRequestDto) {
        return issuerRepository.save(convert(createIssuerRequestDto));
    }

    @Override
    public void deleteIssuer(Long id) {
        issuerRepository.delete(getIssuerById(id));
    }

    @Override
    public Issuer updateIssuer(IssuerRequestDto updateIssuerRequestDto, Long id) {
        Issuer issuer= issuerRepository.getById(id);
        issuer.setBankType(updateIssuerRequestDto.getBankType());
        issuer.setBankName(updateIssuerRequestDto.getBankName());
        issuer.setBankCode(updateIssuerRequestDto.getBankCode());
        return issuerRepository.save(issuer);
    }

    @Override
    public Issuer getIssuerById(Long id) {
        return issuerRepository.getById(id);
    }

    private Issuer convert(IssuerRequestDto createIssuerRequestDto){
        Issuer issuer=new Issuer();
        issuer.setBankCode(createIssuerRequestDto.getBankCode());
        issuer.setBankName(createIssuerRequestDto.getBankName());
        issuer.setBankType(createIssuerRequestDto.getBankType());
        return issuer;
    }

}
