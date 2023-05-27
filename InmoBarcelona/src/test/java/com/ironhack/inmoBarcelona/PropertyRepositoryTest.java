package com.ironhack.inmoBarcelona;

import com.ironhack.inmoBarcelona.models.Property;
import com.ironhack.inmoBarcelona.models.User;
import com.ironhack.inmoBarcelona.repositories.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class PropertyRepositoryTest {
    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * No need to set up data before each test, since a preliminary database is already built in
     * inmoBarcelonaApplication. There are 13 properties in the database. See some key attributes of each below:
     * [
     *   { "area": 89, "roomsNum": 3, "price": 450000 },
     *   { "area": 100, "roomsNum": 3, "price": 395000 },
     *   { "area": 74, "roomsNum": 1, "price": 175000 },
     *   { "area": 152, "roomsNum": 3, "price": 425000 },
     *   { "area": 50, "roomsNum": 2, "price": 240000 },
     *   { "area": 102, "roomsNum": 3, "price": 525000 },
     *   { "area": 139, "roomsNum": 4, "price": 550000 },
     *   { "area": 94, "roomsNum": 2, "price": 370000 },
     *   { "area": 85, "roomsNum": 2, "price": 300000 },
     *   { "area": 95, "roomsNum": 3, "price": 350000 },
     *   { "area": 120, "roomsNum": 4, "price": 450000 },
     *   { "area": 100, "roomsNum": 3, "price": 400000 },
     *   { "area": 110, "roomsNum": 3, "price": 410000 }
     * ]
     */
    @Test
    public void shouldAddProperty() {
        assertEquals(13, propertyRepository.findAll().size());
    }
    @Test
    public void shouldFindByAreaGreaterThanEqual() {
        assertEquals(7, propertyRepository.findByAreaGreaterThanEqual(100).size());
    }
    @Test
    public void shouldFindByAreaLessThanEqual() {
        assertEquals(6, propertyRepository.findByAreaLessThanEqual(99).size());
    }
    @Test
    public void shouldFindByRoomsNumGreaterThanEqual() {
        assertEquals(9, propertyRepository.findByRoomsNumGreaterThanEqual(3).size());
    }
    @Test
    public void shouldFindByPriceLessThanEqual() {
        assertEquals(2, propertyRepository.findByPriceLessThanEqual(299999).size());
    }

    @Test
    public void shouldGetArea() {
        Property property = propertyRepository.findAll().get(0);
        assertEquals(89, property.getArea());
    }
}