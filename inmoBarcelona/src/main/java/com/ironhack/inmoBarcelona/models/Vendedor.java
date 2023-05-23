package com.ironhack.inmoBarcelona.models;

import enums.TipoVendedor;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor extends Usuario {
    private TipoVendedor tipoVendedor;
    /*@OneToMany(mappedBy = "usuario")
    private Set<Inmueble> inmuebles = new HashSet<>();*/
    @OneToMany(mappedBy = "vendedor")
    private Set<Inmueble> inmuebles = new HashSet<>();

    public Vendedor(Long usuarioId, String nombre, String apellido, String email, String contraseña, TipoVendedor tipoVendedor) {
        super(usuarioId, nombre, apellido, email, contraseña);
        this.tipoVendedor = tipoVendedor;
    }

    public void addInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
        inmueble.setVendedor(this);
    }


    /*
+ publicarInmueble()
+ actualizarInmueble()
+ eliminarInmueble()
     */
}
