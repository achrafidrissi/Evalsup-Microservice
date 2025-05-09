package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("PROFESSEUR")
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends Personne {
    @Column(unique = true, nullable = false)
    private String codeProf;
}
