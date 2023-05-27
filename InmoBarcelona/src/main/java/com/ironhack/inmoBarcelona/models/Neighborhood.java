package com.ironhack.inmoBarcelona.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa los distintos barrios de Barcelona. Contiene un nombre y una descripción
 * del barrio que podría ser útil para compradores que no conocen bien la ciudad, y mantiene
 * una lista de todas las direcciones que están dentro de ese vecindario.
 */
@Entity
@Data
@NoArgsConstructor
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long neighborhoodId;
    private String neighborhoodName;
    private String description;

    @OneToMany(mappedBy = "neighborhood")
    @JsonIgnore
    private List<Address> addresses = new ArrayList<>();

    public Neighborhood(String neighborhoodName, String description, List<Address> addresses) {
        this.neighborhoodName = neighborhoodName;
        this.description = description;
        this.addresses = addresses;
    }
}
