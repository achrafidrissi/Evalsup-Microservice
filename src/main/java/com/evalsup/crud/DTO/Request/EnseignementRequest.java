package com.evalsup.crud.DTO.Request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EnseignementRequest {

    @NotNull
    private Long professeurId;

    @NotNull
    private Long sousModuleId;
}
