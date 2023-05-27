package com.ironhack.inmoBarcelona.services.impl;

import com.ironhack.inmoBarcelona.models.Address;
import com.ironhack.inmoBarcelona.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        log.info("Saving new address {} to the database", address.getAddressId());
        return addressRepository.save(address);
    }
}
