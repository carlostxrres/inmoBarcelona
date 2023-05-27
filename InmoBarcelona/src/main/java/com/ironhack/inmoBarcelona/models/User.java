package com.ironhack.inmoBarcelona.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import static jakarta.persistence.FetchType.EAGER;
/**
 * Representa a los usuarios de la plataforma. Cada usuario tiene un nombre,
 * un nombre de usuario y una contraseña. Un usuario puede tener varios roles y
 * puede marcar varios inmuebles como favoritos.
 */
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @ManyToMany(mappedBy = "users")
    private Set<Favorite> favorites = new HashSet<>();

    public User(String name, String username, String password, Collection<Role> roles, Set<Favorite> favorites) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.favorites = favorites;
    }
}
