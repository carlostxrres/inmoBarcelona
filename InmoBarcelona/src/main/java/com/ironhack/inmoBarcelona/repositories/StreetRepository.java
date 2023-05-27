package com.ironhack.inmoBarcelona.repositories;

import com.ironhack.inmoBarcelona.models.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {
}