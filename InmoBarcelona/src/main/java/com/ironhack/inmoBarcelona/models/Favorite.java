package com.ironhack.inmoBarcelona.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * El Comprador puede guardar inmuebles en "favoritos".
 * Favorito es una entidad intermedia entre Comprador e Inmueble. Esta entidad contiene
 * a un set de Usuarios y a un Inmueble.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @ManyToMany
    @JoinTable(
            name = "favorite_users",
            joinColumns = @JoinColumn(name = "favorite_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}