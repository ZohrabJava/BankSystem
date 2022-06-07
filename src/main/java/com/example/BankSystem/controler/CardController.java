package com.example.BankSystem.controler;

import com.example.BankSystem.convertor.CardConvertor;
import com.example.BankSystem.dto.CardDto.CardRequestDto;
import com.example.BankSystem.dto.CardDto.CardResponseDto;
import com.example.BankSystem.enams.CardStatus;
import com.example.BankSystem.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bankSystem/card")
@Api
public class CardController {
    private final CardConvertor cardConvertor;
    private final CardService cardService;

    public CardController(CardService cardService, CardConvertor cardConvertor) {
        this.cardConvertor = cardConvertor;
        this.cardService = cardService;
    }

    @PostMapping
    @ApiOperation("Creat Card")
    public ResponseEntity<CardResponseDto> creatCard(@Valid @RequestBody CardRequestDto creatCardRequestDto) {
        var card = cardService.createCard(creatCardRequestDto);
        var dto = cardConvertor.convert(card);
        return ResponseEntity.ok(dto);

    }

    @GetMapping
    @ApiOperation("Get Card by id")
    public ResponseEntity<CardResponseDto> getById(Long id) {
        var card = cardService.findCardById(id);
        var dto = cardConvertor.convert(card);
        return ResponseEntity.ok(dto);
    }

    @RequestMapping(value = "/{addressId}", method = RequestMethod.PUT)
    @ApiOperation("Update Card by id")
    public ResponseEntity<CardResponseDto> updateIssuer(@PathVariable(value = "addressId") Long id,
                                                        @RequestBody CardRequestDto cardStatusState) {
        if (cardStatusState.getCardStatus().equals(CardStatus.BLOCKED)) {
            var card = cardService.blockCard(id);
            var dto = cardConvertor.convert(card);
            return ResponseEntity.ok(dto);

        } else if (cardStatusState.getCardStatus().equals(CardStatus.ACTIVE)) {
            var card = cardService.activateCard(id);
            var dto = cardConvertor.convert(card);
            return ResponseEntity.ok(dto);

        }
        var card = cardService.findCardById(id);
        var dto = cardConvertor.convert(card);
        return ResponseEntity.ok(dto);
    }

}
