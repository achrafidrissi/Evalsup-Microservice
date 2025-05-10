package com.evalsup.crud.Repository;

import com.evalsup.crud.Entity.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {

    Optional<Enseignement> findByProfesseurIdAndSousModuleId(Long professeurId, Long sousModuleId);
}
