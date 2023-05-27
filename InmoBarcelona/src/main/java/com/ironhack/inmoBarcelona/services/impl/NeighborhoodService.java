package com.ironhack.inmoBarcelona.services.impl;

import com.ironhack.inmoBarcelona.models.Neighborhood;
import com.ironhack.inmoBarcelona.repositories.NeighborhoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NeighborhoodService {

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    public Neighborhood saveNeighborhood(Neighborhood neighborhood) {
        log.info("Saving new neighborhood {} to the database", neighborhood.getNeighborhoodId());
        return neighborhoodRepository.save(neighborhood);
    }
}