package com.ironhack.inmoBarcelona.models;

import enums.EstadoInmueble;
import enums.Orientacion;
import enums.TipoNegocio;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalComercial extends Inmueble {
    private TipoNegocio tipoNegocio;
    private String mobiliarioEquipo;
    /*public LocalComercial(Long inmueble_id, Vendedor vendedor, Direccion dirección, int superficie, int numHabitaciones, int precio, String descripción, EstadoInmueble estadoInmueble, LocalDate fechaPublicacion, Orientacion orientacion, Set<Favorito> favoritos, TipoNegocio tipoNegocio, String mobiliarioEquipo) {
        super(inmueble_id, vendedor, favoritos, dirección, superficie, numHabitaciones, precio, descripción, estadoInmueble, fechaPublicacion, orientacion);
        this.tipoNegocio = tipoNegocio;
        this.mobiliarioEquipo = mobiliarioEquipo;
    }*/

    public LocalComercial(Long inmueble_id, Vendedor vendedor, Direccion dirección, int superficie, int numHabitaciones, int precio, String descripción, EstadoInmueble estadoInmueble, LocalDate fechaPublicacion, Orientacion orientacion, TipoNegocio tipoNegocio, String mobiliarioEquipo) {
        super(inmueble_id, vendedor, new HashSet<>(), dirección, superficie, numHabitaciones, precio, descripción, estadoInmueble, fechaPublicacion, orientacion);
        this.tipoNegocio = tipoNegocio;
        this.mobiliarioEquipo = mobiliarioEquipo;
    }
}
