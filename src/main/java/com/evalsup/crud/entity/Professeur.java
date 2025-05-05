package com.evalsup.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("PROFESSEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends Personne {
    @Column(unique = true, nullable = false)
    private String codeProf;
}
