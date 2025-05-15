package com.evalsup.crud.Controller;

import com.evalsup.crud.DTO.Request.EnseignementRequest;
import com.evalsup.crud.DTO.Response.EnseignementResponse;
import com.evalsup.crud.DTO.ResponseDto;
import com.evalsup.crud.Service.EnseignementService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enseignements")
public class EnseignementController {

    private final EnseignementService enseignementService;

    public EnseignementController(EnseignementService enseignementService) {
        this.enseignementService = enseignementService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<EnseignementResponse>> assign(@Valid @RequestBody EnseignementRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Professeur assigned", enseignementService.assignEnseignement(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<EnseignementResponse>> update(@PathVariable Long id, @Valid @RequestBody EnseignementRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Enseignement updated", enseignementService.updateEnseignement(id, request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<EnseignementResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Enseignement found", enseignementService.getEnseignementById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<EnseignementResponse>>> getAll() {
        return ResponseEntity.ok(new ResponseDto<>("200", "All enseignements", enseignementService.getAllEnseignements()));
    }

    @DeleteMapping("/professeur/{professeurId}/sous-module/{sousModuleId}")
    public ResponseEntity<ResponseDto<String>> delete(
            @PathVariable Long professeurId,
            @PathVariable Long sousModuleId) {
        enseignementService.deleteEnseignement(professeurId, sousModuleId);
        return ResponseEntity.ok(new ResponseDto<>("200", "Enseignement deleted", null));
    }
}
