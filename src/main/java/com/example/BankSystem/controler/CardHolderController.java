package com.example.BankSystem.controler;

import com.example.BankSystem.convertor.CardHolderConvertor;
import com.example.BankSystem.dto.CaedHolderDto.CardHolderRequestDto;
import com.example.BankSystem.dto.CaedHolderDto.CardHolderResponseDto;
import com.example.BankSystem.dto.transferDto.TransferRequestDto;
import com.example.BankSystem.dto.transferDto.TransferResponseDto;
import com.example.BankSystem.service.CardHolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bankSystem/cardHolder")
@Api
public class CardHolderController {
    private final CardHolderService cardHolderService;
    private final CardHolderConvertor cardHolderConvertor;

    public CardHolderController(CardHolderConvertor cardHolderConvertor, CardHolderService cardHolderService) {
        this.cardHolderService = cardHolderService;
        this.cardHolderConvertor = cardHolderConvertor;
    }

    @PostMapping
    @ApiOperation("Create Address ")
    public ResponseEntity<CardHolderResponseDto> creatAddress(@Valid @RequestBody CardHolderRequestDto creatCardHolderRequestDto) {
        var cardHolder = cardHolderService.createCardHolder(creatCardHolderRequestDto);
        return ResponseEntity.ok(cardHolder);

    }

    @GetMapping
    @ApiOperation("Get Card Holder by Id ")
    public ResponseEntity<CardHolderResponseDto> getById(Long id) {
        var cardHolder = cardHolderService.findCardHolderById(id);
        return ResponseEntity.ok(cardHolder);
    }

    @DeleteMapping
    @ApiOperation("Delete Card Holder by id ")
    public ResponseEntity<String> deleteById(Long id) {
        cardHolderService.deleteCardHolder(id);
        return ResponseEntity.ok("Card holder is deleted");
    }

    @RequestMapping(value = "/{cardHolderId}", method = RequestMethod.PUT)
    @ApiOperation("Update Card holder by id ")
    public ResponseEntity<CardHolderResponseDto> updateCardHolder(@Valid @RequestBody CardHolderRequestDto updateCardHolderRequestDto,
                                                              @PathVariable(value = "cardHolderId") Long id) {
        var dto = cardHolderService.updateCardHolder(updateCardHolderRequestDto, id);
        return ResponseEntity.ok(dto);

    }
    @PutMapping
    @ApiOperation("Transfer")
    public ResponseEntity<TransferResponseDto> transfer(@Valid @RequestBody TransferRequestDto transferRequestDto){
        if(transferRequestDto.getIBAN()!=null){
            var transfer=cardHolderService.transferToAccount(transferRequestDto);
            return ResponseEntity.ok(transfer);
        }
        var transfer=cardHolderService.transferToCard(transferRequestDto);
        return ResponseEntity.ok(transfer);
    }
}
