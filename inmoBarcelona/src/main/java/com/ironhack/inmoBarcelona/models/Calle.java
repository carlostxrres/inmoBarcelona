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
public class Calle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calleId;
    private String nombre;
}
