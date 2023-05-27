package com.ironhack.inmoBarcelona.controllers.impl;

import com.ironhack.inmoBarcelona.models.Favorite;
import com.ironhack.inmoBarcelona.services.impl.FavoriteService;
import com.ironhack.inmoBarcelona.services.interfaces.FavoriteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FavoriteController {
    @Autowired
    private FavoriteServiceInterface favoriteService;

    /**
     * Get a list of all favorites
     *
     * @return list of all favorites
     */
    @GetMapping("/favorites")
    @ResponseStatus(HttpStatus.OK)
    public List<Favorite> getFavorites() {
        return favoriteService.getFavorites();
    }

    /**
     * Add a new favorite to a user
     *
     * @param userId the user id
     * @param propertyId the property id
     */
    @PostMapping("/users/{userId}/favorites/{propertyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavoriteToUser(@PathVariable Long userId, @PathVariable Long propertyId) {
        favoriteService.addFavoriteToUser(userId, propertyId);
    }
    /**
     * Delete a favorite
     *
     * @param favoriteId the favorite id
     */
    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable(value = "id") Long favoriteId) {
        favoriteService.deleteFavorite(favoriteId);
        return ResponseEntity.ok().build();
    }
}
