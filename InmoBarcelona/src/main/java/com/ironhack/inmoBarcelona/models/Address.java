package com.ironhack.inmoBarcelona.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la dirección de un inmueble.
 * Contiene información sobre el número de la calle, el piso y la puerta, así como
 * referencias al barrio y a la calle donde se encuentra.
 */
@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @ManyToOne
    @JoinColumn(name = "neighborhoodId")
    private Neighborhood neighborhood;

    @ManyToOne
    @JoinColumn(name = "streetId")
    private Street street;
    private int number;
    private int floor;
    private String door;
    public Address(Neighborhood neighborhood, Street street, int number, int floor, String door) {
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.door = door;
    }
}
