package com.example.BankSystem.service.impl;

import com.example.BankSystem.dto.AccountDto.AccountRequestDto;
import com.example.BankSystem.model.Account;
import com.example.BankSystem.model.Issuer;
import com.example.BankSystem.repository.AccountRepository;
import com.example.BankSystem.repository.IssuerRepository;
import com.example.BankSystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final IssuerRepository issuerRepository;
    public AccountServiceImpl(AccountRepository accountRepository,IssuerRepository issuerRepository) {
        this.accountRepository = accountRepository;
        this.issuerRepository=issuerRepository;
    }

    @Override
    public Account createAccount(AccountRequestDto creatAccountRequestDto) {
        List<Issuer> issuerOptional=issuerRepository.findByBankCodeAndBankName(creatAccountRequestDto.getIssuer().getBankCode(),
                creatAccountRequestDto.getIssuer().getBankName());
        if (!issuerOptional.isEmpty()){
            creatAccountRequestDto.setIssuer(issuerOptional.get(0));
        }
        Account account = convert(creatAccountRequestDto);
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.delete(accountRepository.getById(id));
    }

    @Override
    public Account updateAccount(AccountRequestDto updateAccountRequestDto, Long id) {
        Account account = accountRepository.getById(id);
        List<Issuer> issuerOptional=issuerRepository.findByBankCodeAndBankName(updateAccountRequestDto.getIssuer().getBankCode(),
                updateAccountRequestDto.getIssuer().getBankName());
        if (!issuerOptional.isEmpty()){
            updateAccountRequestDto.setIssuer(issuerOptional.get(0));
        }
        account.setAccountBalance(updateAccountRequestDto.getAccountBalance());
        if (updateAccountRequestDto.getIban() == null || updateAccountRequestDto.getIban().equals("")) {
            account.setIban(generateIban());
        } else {
            account.setIban(updateAccountRequestDto.getIban());
        }
        account.setIssuer(updateAccountRequestDto.getIssuer());
        account.setAccountBalance(updateAccountRequestDto.getAccountBalance());
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        Account account = accountRepository.getById(id);
        return account;
    }

    public Account convert(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setAccountBalance(accountRequestDto.getAccountBalance());
        if (accountRequestDto.getIban() == null || accountRequestDto.getIban().equals("")) {
            account.setIban(generateIban());
        } else {
            account.setIban(accountRequestDto.getIban());
        }
        List<Issuer> issuerOptional=issuerRepository.findByBankCodeAndBankName(accountRequestDto.getIssuer().getBankCode(),
                accountRequestDto.getIssuer().getBankName());
        if (!issuerOptional.isEmpty()){
            accountRequestDto.setIssuer(issuerOptional.get(0));
        }
        account.setIssuer(accountRequestDto.getIssuer());
        account.setAccountBalance(accountRequestDto.getAccountBalance());
        return account;
    }


    private String generateIban() {
        Random random = new Random();
        List<Account> accounts = accountRepository.findAll();
        StringBuilder iban = new StringBuilder();
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < 12; i++) {
                if (i < 2) {
                    iban.append(Character.toChars(random.nextInt('A', 'Z' + 1)));
                } else if (i < 4) {
                    iban.append(Character.toChars(random.nextInt('0', '9' + 1)));
                } else {
                    if (random.nextInt(1, 3) == 1) {
                        iban.append(Character.toChars(random.nextInt('A', 'Z' + 1)));
                    } else {
                        iban.append(Character.toChars(random.nextInt('0', '9' + 1)));
                    }
                }
            }
            for (Account account : accounts) {
                if (account.getIban().contentEquals(iban.toString())) {
                    flag = true;
                    break;
                }
            }

        } while (flag);
        return new String(iban);
    }


}
