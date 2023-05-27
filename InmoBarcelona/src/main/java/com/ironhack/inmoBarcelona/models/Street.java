package com.ironhack.inmoBarcelona.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa las calles de Barcelona. Contiene un nombre y una lista de todas las direcciones
 * que están en esa calle.
 */

@Entity
@Data
@NoArgsConstructor
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long streetId;
    private String streetName;

    @OneToMany(mappedBy = "street")
    @JsonIgnore
    private List<Address> addresses = new ArrayList<>();

    public Street(String streetName, List<Address> addresses) {
        this.streetName = streetName;
        this.addresses = addresses;
    }
}