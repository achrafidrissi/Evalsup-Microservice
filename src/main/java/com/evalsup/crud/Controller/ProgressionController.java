package com.evalsup.crud.Controller;

import com.evalsup.crud.DTO.Request.ProgressionRequest;
import com.evalsup.crud.DTO.Response.ProgressionResponse;
import com.evalsup.crud.DTO.ResponseDto;
import com.evalsup.crud.Service.ProgressionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progressions")
public class ProgressionController {

    private final ProgressionService progressionService;

    public ProgressionController(ProgressionService progressionService) {
        this.progressionService = progressionService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<ProgressionResponse>> create(@Valid @RequestBody ProgressionRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Progression saved", progressionService.createProgression(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<ProgressionResponse>> update(@PathVariable Long id, @Valid @RequestBody ProgressionRequest request) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Progression updated", progressionService.updateProgression(id, request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<ProgressionResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDto<>("200", "Progression found", progressionService.getProgressionById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<ProgressionResponse>>> getAll() {
        return ResponseEntity.ok(new ResponseDto<>("200", "All progressions", progressionService.getAllProgressions()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<String>> delete(@PathVariable Long id) {
        progressionService.deleteProgression(id);
        return ResponseEntity.ok(new ResponseDto<>("200", "Progression deleted", null));
    }
}