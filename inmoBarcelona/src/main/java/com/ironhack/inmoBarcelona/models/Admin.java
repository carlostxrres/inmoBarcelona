package com.ironhack.inmoBarcelona.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
public class Admin extends Usuario {

    public Admin(Long usuarioId, String nombre, String apellido, String email, String contraseña) {
        super(usuarioId, nombre, apellido, email, contraseña);
    }
}
