package com.evalsup.crud.DTO.Request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ModuleRequest {

    @NotBlank
    private String titre;

    @NotNull
    private Long formationId;
}
