package com.example.BankSystem.convertor;

import com.example.BankSystem.dto.AccountDto.AccountRequestDto;
import com.example.BankSystem.dto.AccountDto.AccountResponseDto;
import com.example.BankSystem.model.Account;
import com.example.BankSystem.model.Issuer;
import org.springframework.stereotype.Component;

@Component
public class AccountConvertor {
    public AccountResponseDto convert(AccountRequestDto account){
        return new AccountResponseDto(account.getId(), account.getIban(),
               new Issuer( account.getIssuer().getId(), account.getIssuer().getBankCode(),
                       account.getIssuer().getBankName(),account.getIssuer().getBankType()),
                account.getAccountBalance());
    }
    public AccountResponseDto convert(Account account){
        return new AccountResponseDto(account.getId(), account.getIban(),
                new Issuer( account.getIssuer().getId(), account.getIssuer().getBankCode(),
                        account.getIssuer().getBankName(),account.getIssuer().getBankType()),
                account.getAccountBalance());
    }
}

