package com.ironhack.inmoBarcelona.models;
import enums.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
/*@AllArgsConstructor*/
@NoArgsConstructor
public class Vivienda extends Inmueble {
    /*public Vivienda(Long inmueble_id, Vendedor vendedor, Direccion dirección, int superficie, int numHabitaciones, int precio, String descripción, EstadoInmueble estadoInmueble, LocalDate fechaPublicacion, Orientacion orientacion, Set<Favorito> favoritos) {
        super(inmueble_id, vendedor, favoritos, dirección, superficie, numHabitaciones, precio, descripción, estadoInmueble, fechaPublicacion, orientacion);
    }*/
    public Vivienda(Long inmueble_id, Vendedor vendedor, Direccion dirección, int superficie, int numHabitaciones, int precio, String descripción, EstadoInmueble estadoInmueble, LocalDate fechaPublicacion, Orientacion orientacion) {
        super(inmueble_id, vendedor, new HashSet<>(), dirección, superficie, numHabitaciones, precio, descripción, estadoInmueble, fechaPublicacion, orientacion);
    }



}
