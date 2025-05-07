package com.evalsup.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("ETUDIANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne {
    @Column(unique = true, nullable = false)
    private String codeEtu;
}
