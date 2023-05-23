package com.ironhack.inmoBarcelona.models;

import com.ironhack.inmoBarcelona.models.Favorito;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comprador extends Usuario {
    /*@ManyToMany(mappedBy = "comprador")
    private Set<Favorito> favoritos = new HashSet();*/
    @ManyToMany(mappedBy = "compradores")
    private Set<Favorito> favoritos = new HashSet<>();
    public Comprador(Long usuarioId, String nombre, String apellido, String email, String contraseña) {
        super(usuarioId, nombre, apellido, email, contraseña);
    }

    /*// Método para agregar un inmueble a favoritos
    public void addFavorito(Inmueble inmueble) {
        Favorito favorito = new Favorito(this, inmueble);
        favoritos.add(favorito);
        inmueble.getFavoritos().add(favorito);
    }

    // Método para eliminar un inmueble de favoritos
    public void removeFavorito(Inmueble inmueble) {
        Favorito favorito = new Favorito(this, inmueble);
        inmueble.getFavoritos().remove(favorito);
        favoritos.remove(favorito);
        favorito.setUsuario(null);
        favorito.setInmueble(null);
    }*/
}
