package com.evalsup.crud.Repository;

import com.evalsup.crud.Entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
