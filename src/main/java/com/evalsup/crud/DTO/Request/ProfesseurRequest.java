package com.evalsup.crud.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfesseurRequest {
    @NotBlank(message = "Nom is required")
    private String nom;

    @NotBlank(message = "Téléphone is required")
    private String telephone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Code professeur is required")
    private String codeProf;
}
