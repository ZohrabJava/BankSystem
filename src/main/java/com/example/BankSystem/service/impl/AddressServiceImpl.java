package com.example.BankSystem.service.impl;

import com.example.BankSystem.dto.AddressDto.AddressRequestDto;
import com.example.BankSystem.model.Address;
import com.example.BankSystem.repository.AddressRepository;
import com.example.BankSystem.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(AddressRequestDto creatAddressRequestDto) {
        return addressRepository.save(convert(creatAddressRequestDto));
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.delete(addressRepository.getById(id));
    }

    @Override
    public Address updateAddress(AddressRequestDto updateAddressRequestDto, Long id) {
        Address address = addressRepository.getById(id);
        address.setStreetAddress(updateAddressRequestDto.getStreetAddress());
        address.setCity(updateAddressRequestDto.getCity());
        address.setHouseNumber(updateAddressRequestDto.getHouseNumber());
        address.setState(updateAddressRequestDto.getState());
        address.setZipCode(updateAddressRequestDto.getZipCode());
        return addressRepository.save(address);
    }

    public Address convert(AddressRequestDto addressRequestDto) {
        Address address = new Address();
        address.setStreetAddress(addressRequestDto.getStreetAddress());
        address.setCity(addressRequestDto.getCity());
        address.setHouseNumber(addressRequestDto.getHouseNumber());
        address.setState(addressRequestDto.getState());
        address.setZipCode(addressRequestDto.getZipCode());
        return address;
    }
}
