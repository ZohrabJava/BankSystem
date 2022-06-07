package com.example.BankSystem.repository;

import com.example.BankSystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByCityAndHouseNumberAndStateAndStreetAddressAndZipCode( String houseNumber, String streetAddress, String city, String state, String zipCode);
}
