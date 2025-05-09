package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Progression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean estCompleter;
    private LocalDate dateCompletion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sous_module_id")
    private SousModule sousModule;
}
