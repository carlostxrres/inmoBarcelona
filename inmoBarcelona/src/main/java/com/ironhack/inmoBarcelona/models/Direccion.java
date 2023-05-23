package com.ironhack.inmoBarcelona.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long direccionId;
    private String barrio; // TO DO: Change to Barrio
    private String calle; // TO DO: Change to Calle
    private int número;
    private int piso;
    private String puerta;
}
