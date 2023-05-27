package com.ironhack.inmoBarcelona.controllers.interfaces;

import com.ironhack.inmoBarcelona.models.Property;

import java.util.List;

public interface PropertyControllerInterface {
    /**
     * Retrieves a list of all properties
     *
     * @return list of all properties
     */
    List<Property> getProperties();

    /**
     * Saves a new property
     *
     * @param property the property to be saved
     * @return the saved property
     */
    Property saveProperty(Property property);
}
