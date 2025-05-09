package com.evalsup.crud.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FormationRequest {

    @NotBlank
    private String titre;
}
