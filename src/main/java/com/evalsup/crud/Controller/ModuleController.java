package com.evalsup.crud.Controller;


import com.evalsup.crud.DTO.Request.ModuleRequest;
import com.evalsup.crud.DTO.Response.ModuleResponse;
import com.evalsup.crud.DTO.ResponseDto;
import com.evalsup.crud.Service.ModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<ModuleResponse>> create(@Valid @RequestBody ModuleRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Module created", moduleService.createModule(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<ModuleResponse>> update(@PathVariable Long id, @Valid @RequestBody ModuleRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Module updated", moduleService.updateModule(id, request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<ModuleResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Module found", moduleService.getModuleById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<ModuleResponse>>> getAll() {
        return ResponseEntity.ok(new ResponseDto<>("200", "All modules", moduleService.getAllModules()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<String>> delete(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "Module deleted", null));
    }
}
