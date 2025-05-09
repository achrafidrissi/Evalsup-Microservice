package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String telephone;
    private String email;
    private String password;

    @Column(insertable = false, updatable = false)
    private String role;
}
