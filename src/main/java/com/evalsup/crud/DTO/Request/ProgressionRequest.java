package com.evalsup.crud.DTO.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ProgressionRequest {

    @NotNull
    private Long etudiantId;

    @NotNull
    private Long sousModuleId;

    @NotNull
    private Boolean estCompleter;

    private LocalDate dateCompletion;
}
