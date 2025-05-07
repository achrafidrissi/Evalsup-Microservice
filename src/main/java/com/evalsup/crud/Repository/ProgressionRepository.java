package com.evalsup.crud.Repository;

import com.evalsup.crud.Entity.Progression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressionRepository extends JpaRepository<Progression, Long> {
}
