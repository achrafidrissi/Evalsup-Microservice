package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("ADMIN")
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor

public class Admin extends Personne {
}
