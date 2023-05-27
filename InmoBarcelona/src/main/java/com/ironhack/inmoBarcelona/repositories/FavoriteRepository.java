package com.ironhack.inmoBarcelona.repositories;

import com.ironhack.inmoBarcelona.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}