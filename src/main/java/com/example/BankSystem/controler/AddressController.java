package com.example.BankSystem.controler;

import com.example.BankSystem.convertor.AddressConvertor;
import com.example.BankSystem.dto.AddressDto.AddressRequestDto;
import com.example.BankSystem.dto.AddressDto.AddressResponseDto;
import com.example.BankSystem.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bankSystem/address")
@Api
public class AddressController {
    private final AddressService addressService;
    private final AddressConvertor addressConvertor;

    public AddressController(AddressService addressService, AddressConvertor addressConvertor) {
        this.addressService = addressService;
        this.addressConvertor = addressConvertor;
    }
    @PostMapping
    @ApiOperation("Creat Address")
    public ResponseEntity<AddressResponseDto> creatAddress(@Valid @RequestBody AddressRequestDto creatAddressRequestDto) {
        var address = addressService.createAddress(creatAddressRequestDto);
        var dto = addressConvertor.convert(address);
        return ResponseEntity.ok(dto);

    }

    @GetMapping
    @ApiOperation("Get Address by id")
    public ResponseEntity<AddressResponseDto> getById(Long id) {
        var address = addressService.getAddressById(id);
        var dto = addressConvertor.convert(address);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @ApiOperation("Delete Address by id")
    public ResponseEntity<String> deleteById(Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Address is deleted");
    }

    @RequestMapping(value = "/{addressId}", method = RequestMethod.PUT)
    @ApiOperation("Update Address by id")
    public ResponseEntity<AddressResponseDto> updateIssuer(@Valid @RequestBody AddressRequestDto
                                                                  updateAddressRequestDto, @PathVariable(value = "addressId") Long id) {
        var issuer = addressService.updateAddress(updateAddressRequestDto, id);
        var dto = addressConvertor.convert(issuer);
        return ResponseEntity.ok(dto);

    }
}
