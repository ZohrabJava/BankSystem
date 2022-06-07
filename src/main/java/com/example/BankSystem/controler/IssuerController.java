package com.example.BankSystem.controler;


import com.example.BankSystem.convertor.IssuerConvertor;
import com.example.BankSystem.dto.IssuerDto.IssuerRequestDto;
import com.example.BankSystem.dto.IssuerDto.IssuerResponseDto;
import com.example.BankSystem.service.IssuerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bankSystem/issuer")
@Api
public class IssuerController {
    private final IssuerService issuerService;
    private final IssuerConvertor issuerConvertor;

    public IssuerController(IssuerService issuerService, IssuerConvertor issuerConvertor) {
        this.issuerService = issuerService;
        this.issuerConvertor = issuerConvertor;
    }

    @PostMapping
    @ApiOperation("Create Issuer ")
    public ResponseEntity<IssuerResponseDto> creatIssuer(@Valid @RequestBody IssuerRequestDto createIssuerRequestDto) {
        var issuer = issuerService.createIssuer(createIssuerRequestDto);
        var dto = issuerConvertor.convert(issuer);
        return ResponseEntity.ok(dto);

    }

    @GetMapping
    @ApiOperation("Get Issuer ")
    public ResponseEntity<IssuerResponseDto> getById(Long id) {
        var issuer = issuerService.getIssuerById(id);
        var dto = issuerConvertor.convert(issuer);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @ApiOperation("Delete Issuer ")
    public ResponseEntity<String> deleteById(Long id) {
        issuerService.deleteIssuer(id);
        return ResponseEntity.ok("Issuer is deleted");
    }

    @RequestMapping(value = "/{issuerId}", method = RequestMethod.PUT)
    @ApiOperation("Update Issuer ")
    public ResponseEntity<IssuerResponseDto> updateIssuer(@Valid @RequestBody IssuerRequestDto
                                                                  updateIssuerRequest, @PathVariable(value = "issuerId") Long id) {
        var issuer = issuerService.updateIssuer(updateIssuerRequest, id);
        var dto = issuerConvertor.convert(issuer);
        return ResponseEntity.ok(dto);

    }

}
