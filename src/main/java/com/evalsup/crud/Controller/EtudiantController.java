package com.evalsup.crud.Controller;

import com.evalsup.crud.DTO.Request.EtudiantRequest;
import com.evalsup.crud.DTO.Response.EtudiantResponse;
import com.evalsup.crud.DTO.ResponseDto;
import com.evalsup.crud.Service.EtudiantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<EtudiantResponse>> create(@Valid @RequestBody EtudiantRequest request) {
        EtudiantResponse response = etudiantService.createEtudiant(request);
        return ResponseEntity.ok(new ResponseDto<>("200", "Etudiant created", response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<EtudiantResponse>> update(@PathVariable Long id, @Valid @RequestBody EtudiantRequest request) {
        EtudiantResponse response = etudiantService.updateEtudiant(id, request);
        return ResponseEntity.ok(new ResponseDto<>("200", "Etudiant updated", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<EtudiantResponse>> getById(@PathVariable Long id) {
        EtudiantResponse response = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "Etudiant found", response));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<EtudiantResponse>>> getAll() {
        List<EtudiantResponse> list = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(new ResponseDto<>("200", "List of etudiants", list));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<String>> delete(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "Etudiant deleted", null));
    }
}
