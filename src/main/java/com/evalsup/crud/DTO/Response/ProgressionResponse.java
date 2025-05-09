package com.evalsup.crud.DTO.Response;

import java.time.LocalDate;

public record ProgressionResponse(Long id, Long etudiantId, Long sousModuleId, boolean estCompleter, LocalDate dateCompletion) {
}
