package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("ETUDIANT")
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne {
    @Column(unique = true, nullable = false)
    private String codeEtu;
}
