package com.ironhack.inmoBarcelona.services.impl;

import com.ironhack.inmoBarcelona.exceptions.ResourceNotFoundException;
import com.ironhack.inmoBarcelona.models.Favorite;
import com.ironhack.inmoBarcelona.models.Property;
import com.ironhack.inmoBarcelona.models.Role;
import com.ironhack.inmoBarcelona.models.User;
import com.ironhack.inmoBarcelona.repositories.PropertyRepository;
import com.ironhack.inmoBarcelona.repositories.RoleRepository;
import com.ironhack.inmoBarcelona.repositories.UserRepository;
import com.ironhack.inmoBarcelona.services.interfaces.FavoriteServiceInterface;
import com.ironhack.inmoBarcelona.services.interfaces.PropertyServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PropertyService implements PropertyServiceInterface {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Property getProperty(Long propertyId) {
        log.info("Fetching property with id {}", propertyId);
        Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new RuntimeException("Property not found"));
        return property;
    }

    public List<Property> getProperties() {
        log.info("Fetching all properties");
        return propertyRepository.findAll();
    }

    public Property saveProperty(Property property) {
        log.info("Saving new property {} to the database", property.getPropertyId());
        return propertyRepository.save(property);
    }

    @Override
    public Property updateProperty(Long propertyId, Property property) {
        Property existingProperty = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property", "id", propertyId));
        return propertyRepository.save(existingProperty);
    }

    @Override
    public void deleteProperty(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property", "id", propertyId));
        propertyRepository.delete(property);
    }
}
