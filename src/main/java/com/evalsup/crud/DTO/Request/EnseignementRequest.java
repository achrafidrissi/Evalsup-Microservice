package com.evalsup.crud.DTO.Request;

import jakarta.validation.constraints.*;

public class EnseignementRequest {

    @NotNull
    private Long professeurId;

    @NotNull
    private Long sousModuleId;

    // No-arg constructor
    public EnseignementRequest() {
    }

    // All-args constructor
    public EnseignementRequest(Long professeurId, Long sousModuleId) {
        this.professeurId = professeurId;
        this.sousModuleId = sousModuleId;
    }

    // Getters and Setters
    public Long getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(Long professeurId) {
        this.professeurId = professeurId;
    }

    public Long getSousModuleId() {
        return sousModuleId;
    }

    public void setSousModuleId(Long sousModuleId) {
        this.sousModuleId = sousModuleId;
    }
}
