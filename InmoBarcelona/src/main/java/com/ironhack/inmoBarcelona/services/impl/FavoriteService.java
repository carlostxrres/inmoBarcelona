package com.ironhack.inmoBarcelona.services.impl;

import com.ironhack.inmoBarcelona.exceptions.ResourceNotFoundException;
import com.ironhack.inmoBarcelona.services.interfaces.FavoriteServiceInterface;
import com.ironhack.inmoBarcelona.models.Favorite;
import com.ironhack.inmoBarcelona.models.Property;
import com.ironhack.inmoBarcelona.models.User;
import com.ironhack.inmoBarcelona.repositories.FavoriteRepository;
import com.ironhack.inmoBarcelona.repositories.PropertyRepository;
import com.ironhack.inmoBarcelona.repositories.UserRepository;
import jakarta.el.PropertyNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavoriteService implements FavoriteServiceInterface {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Favorite> getFavorites() {
        log.info("Fetching all favorites");
        return favoriteRepository.findAll();
    }

    /**
     * Retrieve the user and property objects from the repository
     * Create a new favorite, set the property and add it to the user's favorites collection
     * Save the favorite to persist the changes
     *
     * @param userId
     * @param propertyId
     * @return
     */
    @Override
    public Favorite addFavoriteToUser(Long userId, Long propertyId) {
        log.info("Adding favorite property to user");

        // Retrieve the user and property objects from the repository
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new PropertyNotFoundException("Property not found"));

        // Create a new favorite, set the property and add it to the user's favorites collection
        Favorite favorite = new Favorite();
        favorite.setProperty(property);
        favorite.getUsers().add(user);

        // Save the favorite to persist the changes
        return favoriteRepository.save(favorite);
    }

    @Override
    public void deleteFavorite(Long favoriteId) {
        Favorite favorite = favoriteRepository.findById(favoriteId)
                .orElseThrow(() -> new ResourceNotFoundException("Favorite", "id", favoriteId));
        favoriteRepository.delete(favorite);
    }
}
