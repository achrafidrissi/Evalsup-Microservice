package com.evalsup.crud.Controller;

import com.evalsup.crud.DTO.Request.FormationRequest;
import com.evalsup.crud.DTO.Response.FormationResponse;
import com.evalsup.crud.DTO.ResponseDto;
import com.evalsup.crud.Service.FormationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    private final FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<FormationResponse>> create(@Valid @RequestBody FormationRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Formation created", formationService.createFormation(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<FormationResponse>> update(@PathVariable Long id, @Valid @RequestBody FormationRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Formation updated", formationService.updateFormation(id, request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<FormationResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Formation found", formationService.getFormationById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<FormationResponse>>> getAll() {
        return ResponseEntity.ok(new ResponseDto<>("200", "All formations", formationService.getAllFormations()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<String>> delete(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "Formation deleted", null));
    }
}
