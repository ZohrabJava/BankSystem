package com.example.BankSystem.convertor;

import com.example.BankSystem.dto.AddressDto.AddressRequestDto;
import com.example.BankSystem.dto.AddressDto.AddressResponseDto;
import com.example.BankSystem.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConvertor {
    public AddressResponseDto convert(AddressRequestDto address){
        return new AddressResponseDto(address.getId(),address.getHouseNumber(),address.getStreetAddress(),
                address.getCity(), address.getState(), address.getZipCode());
    }
    public AddressResponseDto convert(Address address){
        return new AddressResponseDto(address.getId(),address.getHouseNumber(),address.getStreetAddress(),
                address.getCity(), address.getState(), address.getZipCode());
    }
}
