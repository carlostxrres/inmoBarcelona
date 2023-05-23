package com.ironhack.inmoBarcelona.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Tiene que ser Entity, siendo una clase abstracta? Tiene que tener constructores?
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;

    /*
     + autenticarse()
     + publicarInmueble()
     + actualizarInmueble()
     + eliminarInmueble()
     */
}
