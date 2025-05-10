package com.evalsup.crud.Repository;

import com.evalsup.crud.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
