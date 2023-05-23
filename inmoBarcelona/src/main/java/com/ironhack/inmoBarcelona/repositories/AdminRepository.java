package com.ironhack.inmoBarcelona.repositories;

import com.ironhack.inmoBarcelona.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}