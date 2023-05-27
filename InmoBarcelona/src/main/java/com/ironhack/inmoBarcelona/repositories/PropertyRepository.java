package com.ironhack.inmoBarcelona.repositories;

import com.ironhack.inmoBarcelona.models.Property;
import com.ironhack.inmoBarcelona.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findByPropertyId(Long propertyId);
    List<Property> findByAreaGreaterThanEqual(int area);
    List<Property> findByAreaLessThanEqual(int area);
    List<Property> findByRoomsNumGreaterThanEqual(int roomsNum);
    List<Property> findByPriceLessThanEqual(int price);
}