package com.ironhack.inmoBarcelona.controllers.impl;

import com.ironhack.inmoBarcelona.models.Favorite;
import com.ironhack.inmoBarcelona.models.Property;
import com.ironhack.inmoBarcelona.services.interfaces.PropertyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PropertyController {

    /**
     * Property service for accessing property data
     */
    @Autowired
    private PropertyServiceInterface propertyService;

    /**
     * Get a list of all properties
     *
     * @return list of all properties
     */
    @GetMapping("/properties")
    @ResponseStatus(HttpStatus.OK)
    public List<Property> getProperties() {
        return propertyService.getProperties();
    }

    /**
     * Save a new property
     *
     * @param property the property to be saved
     */
    @PostMapping("/properties")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProperty(@RequestBody Property property) {
        propertyService.saveProperty(property);
    }

    /**
     * Update a property
     *
     * @param propertyId the property id
     * @param property the property to be updated
     */
    @PutMapping("/properties/{id}")
    public Property updateProperty(@PathVariable(value = "id") Long propertyId, @RequestBody Property property) {
        return propertyService.updateProperty(propertyId, property);
    }
    /**
     * Delete a property
     *
     * @param propertyId the property id
     */
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable(value = "id") Long propertyId) {
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.ok().build();
    }
}
