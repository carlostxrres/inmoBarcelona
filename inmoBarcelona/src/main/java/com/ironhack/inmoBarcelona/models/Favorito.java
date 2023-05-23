package com.ironhack.inmoBarcelona.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorito {
    /**
     * El Comprador puede guardar inmuebles en "favoritos".
     * Favorito es una entidad intermedia entre Comprador e Inmueble. Esta entidad contiene
     * a un set de Usuarios y a un Inmueble.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoritoId;

    @ManyToMany
    @JoinColumn(name = "comprador_id")
    private Set<Comprador> compradores = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

}