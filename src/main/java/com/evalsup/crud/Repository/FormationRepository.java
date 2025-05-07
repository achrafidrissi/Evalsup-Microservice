package com.evalsup.crud.Repository;

import com.evalsup.crud.Entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
}
