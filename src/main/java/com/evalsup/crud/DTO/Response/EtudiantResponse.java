package com.evalsup.crud.DTO.Response;

public record EtudiantResponse(
        Long id,
        String nom,
        String email,
        String telephone,
        String codeEtu) {}
