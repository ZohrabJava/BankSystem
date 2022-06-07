package com.example.BankSystem.service;

import com.example.BankSystem.dto.AccountDto.AccountRequestDto;
import com.example.BankSystem.model.Account;

public interface AccountService {
    Account createAccount(AccountRequestDto creatAccountRequestDto);

    void deleteAccount(Long id);

    Account updateAccount(AccountRequestDto updateAccountRequestDto, Long id);

    public Account getAccountById(Long id);

}
