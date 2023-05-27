package com.ironhack.inmoBarcelona.services.impl;

import com.ironhack.inmoBarcelona.models.Street;
import com.ironhack.inmoBarcelona.repositories.StreetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public Street saveStreet(Street street) {
        log.info("Saving new street {} to the database", street.getStreetId());
        return streetRepository.save(street);
    }
}