package com.evalsup.crud.Repository;

import com.evalsup.crud.Entity.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {
}
