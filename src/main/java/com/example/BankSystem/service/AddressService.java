package com.example.BankSystem.service;

import com.example.BankSystem.dto.AddressDto.AddressRequestDto;
import com.example.BankSystem.model.Address;

public interface AddressService {
    Address createAddress(AddressRequestDto creatAddressRequestDto);

    void deleteAddress(Long id);

    Address updateAddress(AddressRequestDto updateAddressRequestDto, Long id);

    Address getAddressById(Long id);
}
