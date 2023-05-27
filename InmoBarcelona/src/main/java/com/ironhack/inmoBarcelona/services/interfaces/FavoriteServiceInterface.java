package com.ironhack.inmoBarcelona.services.interfaces;

import com.ironhack.inmoBarcelona.models.Favorite;

import java.util.List;

public interface FavoriteServiceInterface {
    List<Favorite> getFavorites();
    Favorite addFavoriteToUser(Long userId, Long propertyId);
    void deleteFavorite(Long favoriteId);
}
