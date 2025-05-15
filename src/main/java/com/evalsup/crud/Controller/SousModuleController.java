package com.evalsup.crud.Controller;

import com.evalsup.crud.DTO.Request.SousModuleRequest;
import com.evalsup.crud.DTO.Response.SousModuleResponse;
import com.evalsup.crud.DTO.ResponseDto;
import com.evalsup.crud.Service.SousModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sous-modules")
public class SousModuleController {

    private final SousModuleService sousModuleService;

    public SousModuleController(SousModuleService sousModuleService) {
        this.sousModuleService = sousModuleService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<SousModuleResponse>> create(@Valid @RequestBody SousModuleRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "SousModule created", sousModuleService.createSousModule(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<SousModuleResponse>> update(@PathVariable Long id, @Valid @RequestBody SousModuleRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "SousModule updated", sousModuleService.updateSousModule(id, request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<SousModuleResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDto<>("200", "SousModule found", sousModuleService.getSousModuleById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<SousModuleResponse>>> getAll() {
        return ResponseEntity.ok(new ResponseDto<>("200", "All sous-modules", sousModuleService.getAllSousModules()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<String>> delete(@PathVariable Long id) {
        sousModuleService.deleteSousModule(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "SousModule deleted", null));
    }
}
