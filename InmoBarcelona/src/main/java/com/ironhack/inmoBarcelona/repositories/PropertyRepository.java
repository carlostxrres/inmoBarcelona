package com.ironhack.inmoBarcelona.repositories;

import com.ironhack.inmoBarcelona.models.Property;
import com.ironhack.inmoBarcelona.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findByPropertyId(Long propertyId);
}