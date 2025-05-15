package com.evalsup.crud.Controller;

import com.evalsup.crud.DTO.Request.ProfesseurRequest;
import com.evalsup.crud.DTO.Response.ProfesseurResponse;
import com.evalsup.crud.DTO.ResponseDto;
import com.evalsup.crud.Service.ProfesseurService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    private final ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<ProfesseurResponse>> create(@Valid @RequestBody ProfesseurRequest request) {
        ProfesseurResponse response = professeurService.createProfesseur(request);
        return ResponseEntity.ok(new ResponseDto<>("200", "Professeur created", response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<ProfesseurResponse>> update(@PathVariable Long id, @Valid @RequestBody ProfesseurRequest request) {
        ProfesseurResponse response = professeurService.updateProfesseur(id, request);
        return ResponseEntity.ok(new ResponseDto<>("200", "Professeur updated", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<ProfesseurResponse>> getById(@PathVariable Long id) {
        ProfesseurResponse response = professeurService.getProfesseurById(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "Professeur found", response));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<ProfesseurResponse>>> getAll() {
        List<ProfesseurResponse> list = professeurService.getAllProfesseurs();
        return ResponseEntity.ok(new ResponseDto<>("200", "List of professeurs", list));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<String>> delete(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "Professeur deleted", null));
    }
}
