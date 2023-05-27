package com.ironhack.inmoBarcelona.models;

import com.ironhack.inmoBarcelona.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Inmueble es la entidad principal de la aplicación. Esta entidad contiene
 * a un Usuario (el propietario), a un set de Favoritos, a una Dirección, un área, un número de habitaciones,
 * un precio, una descripción, un estado, una fecha de publicación y una orientación.
 */
@Entity
@Data
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "property")
    private Set<Favorite> favorites = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private int area;
    private int roomsNum;
    private int price;
    private String description;
    private PropertyStatus propertyStatus;
    private LocalDate publicationDate;
    private Orientation orientation;

    public Property(User user, Set<Favorite> favorites, Address address, int area, int roomsNum, int price, String description, PropertyStatus propertyStatus, LocalDate publicationDate, Orientation orientation) {
        this.user = user;
        this.favorites = favorites;
        this.address = address;
        this.area = area;
        this.roomsNum = roomsNum;
        this.price = price;
        this.description = description;
        this.propertyStatus = propertyStatus;
        this.publicationDate = publicationDate;
        this.orientation = orientation;
    }
}