package com.evalsup.crud.Repository;

import com.evalsup.crud.Entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
