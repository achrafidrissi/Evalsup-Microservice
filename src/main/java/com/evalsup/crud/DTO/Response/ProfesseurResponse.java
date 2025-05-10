package com.evalsup.crud.DTO.Response;

public record ProfesseurResponse(
        Long id,
        String nom,
        String email,
        String telephone,
        String codeProf
) {}
