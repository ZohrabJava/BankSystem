package com.example.BankSystem.controler;

import com.example.BankSystem.convertor.AccountConvertor;
import com.example.BankSystem.dto.AccountDto.AccountRequestDto;
import com.example.BankSystem.dto.AccountDto.AccountResponseDto;
import com.example.BankSystem.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bankSystem/account")
@Api
public class AccountController {
    private final AccountService accountService;
    private final AccountConvertor accountConvertor;

    public AccountController(AccountService accountService, AccountConvertor accountConvertor) {
        this.accountService = accountService;
        this.accountConvertor = accountConvertor;
    }
    @PostMapping
    @ApiOperation("Creat Account")
    public ResponseEntity<AccountResponseDto> creatAddress(@Valid @RequestBody AccountRequestDto creatAccountRequestDto) {
        var account = accountService.createAccount(creatAccountRequestDto);
        var dto = accountConvertor.convert(account);
        return ResponseEntity.ok(dto);

    }

    @GetMapping
    @ApiOperation("Get Account by id")
    public ResponseEntity<AccountResponseDto> getById(Long id) {
        var account = accountService.getAccountById(id);
        var dto = accountConvertor.convert(account);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @ApiOperation("Delete Account by id")
    public ResponseEntity<String> deleteById(Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Address is deleted");
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    @ApiOperation("Update Account by id")
    public ResponseEntity<AccountResponseDto> updateIssuer(@Valid @RequestBody AccountRequestDto
                                                                   updateAccountRequestDto, @PathVariable(value = "accountId") Long id) {
        var issuer = accountService.updateAccount(updateAccountRequestDto, id);
        var dto = accountConvertor.convert(issuer);
        return ResponseEntity.ok(dto);

    }

}
