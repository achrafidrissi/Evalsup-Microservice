package com.evalsup.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("ADMIN")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Admin extends Personne {
}
