package com.ironhack.inmoBarcelona.services.interfaces;

import com.ironhack.inmoBarcelona.models.Favorite;
import com.ironhack.inmoBarcelona.models.Property;
import com.ironhack.inmoBarcelona.models.User;

import java.util.List;

/**
 * The UserServiceInterface is an interface that defines the methods that are available to perform operations on User entities.
 */
public interface PropertyServiceInterface {

    /**
     * This method is used to save a Property entity to the database.
     *
     * @param property the Property entity to be saved.
     * @return the saved Property entity.
     */
    Property saveProperty(Property property);

    /**
     * This method is used to retrieve a User from the database by its username.
     *
     * @param propertyId the id of the Property to be retrieved.
     * @return the retrieved Property entity.
     */
    Property getProperty(Long propertyId);

    /**
     * This method is used to retrieve all Property entities from the database.
     *
     * @return a List of all User entities.
     */
    List<Property> getProperties();

    /**
     * This method is used to update a Property entity in the database.
     *
     * @param propertyId the id of the Property to be updated.
     * @param property the Property entity to be updated.
     * @return the updated Property entity.
     */
    Property updateProperty(Long propertyId, Property property);
    /** This method is used to delete a Property entity from the database.
     *
     * @param propertyId the id of the Property to be deleted.
     */
    void deleteProperty(Long propertyId);
}

