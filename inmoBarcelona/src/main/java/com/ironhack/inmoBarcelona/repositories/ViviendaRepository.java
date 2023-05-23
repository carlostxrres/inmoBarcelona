package com.ironhack.inmoBarcelona.repositories;

import com.ironhack.inmoBarcelona.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda, Long> {
}