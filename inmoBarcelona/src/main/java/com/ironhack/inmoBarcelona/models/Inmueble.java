package com.ironhack.inmoBarcelona.models;

import enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inmueble_id;
    /*@ManyToOne
    private Vendedor vendedor;*/
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @OneToMany(mappedBy = "inmueble")
    private Set<Favorito> favoritos = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;
    private int superficie;
    private int numHabitaciones;
    private int precio;
    private String descripción;
    private EstadoInmueble estadoInmueble;
    private LocalDate fechaPublicacion;
    private Orientacion orientacion;



    /*
    getDetalles()
    setDetalles()
     */
}