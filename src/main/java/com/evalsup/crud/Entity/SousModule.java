package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class SousModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "module_id")
    private Module module;
}
