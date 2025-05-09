package com.evalsup.crud.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    private List<Module> modules = new ArrayList<>();
}
