package com.ironhack.inmoBarcelona.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa los distintos roles que pueden tener los usuarios en la plataforma, que le dan
 * unos u otros permisos. Se definen tres por defecto: "ROLE_BUYER", "ROLE_SELLER" y "ROLE_ADMIN".
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
