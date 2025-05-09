package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Enseignement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sous_module_id")
    private SousModule sousModule;
}
