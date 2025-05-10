package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.ProgressionRequest;
import com.evalsup.crud.DTO.Response.ProgressionResponse;
import com.evalsup.crud.Entity.Etudiant;
import com.evalsup.crud.Entity.Progression;
import com.evalsup.crud.Entity.SousModule;
import com.evalsup.crud.Repository.EtudiantRepository;
import com.evalsup.crud.Repository.ProgressionRepository;
import com.evalsup.crud.Repository.SousModuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class ProgressionServiceImpl implements ProgressionService{

    private final ProgressionRepository progressionRepo;
    private final EtudiantRepository etudiantRepo;
    private final SousModuleRepository sousModuleRepo;

    public ProgressionServiceImpl(
            ProgressionRepository progressionRepo,
            EtudiantRepository etudiantRepo,
            SousModuleRepository sousModuleRepo
    ) {
        this.progressionRepo = progressionRepo;
        this.etudiantRepo = etudiantRepo;
        this.sousModuleRepo = sousModuleRepo;
    }

    @Override
    public ProgressionResponse createProgression(ProgressionRequest request) {
        Etudiant etu = etudiantRepo.findById(request.getEtudiantId())
                .orElseThrow(() -> new EntityNotFoundException("Etudiant not found"));

        SousModule sm = sousModuleRepo.findById(request.getSousModuleId())
                .orElseThrow(() -> new EntityNotFoundException("SousModule not found"));

        Progression progression = new Progression();
        progression.setEtudiant(etu);
        progression.setSousModule(sm);
        progression.setEstCompleter(request.getEstCompleter());
        progression.setDateCompletion(request.getDateCompletion());

        Progression saved = progressionRepo.save(progression);
        return new ProgressionResponse(
                saved.getId(),
                etu.getId(),
                sm.getId(),
                saved.isEstCompleter(),
                saved.getDateCompletion()
        );
    }

    @Override
    public ProgressionResponse updateProgression(Long id, ProgressionRequest request) {
        Progression progression = progressionRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Progression not found"));

        Etudiant etu = etudiantRepo.findById(request.getEtudiantId())
                .orElseThrow(() -> new EntityNotFoundException("Etudiant not found"));

        SousModule sm = sousModuleRepo.findById(request.getSousModuleId())
                .orElseThrow(() -> new EntityNotFoundException("SousModule not found"));

        progression.setEtudiant(etu);
        progression.setSousModule(sm);
        progression.setEstCompleter(request.getEstCompleter());
        progression.setDateCompletion(request.getDateCompletion());

        Progression updated = progressionRepo.save(progression);
        return new ProgressionResponse(
                updated.getId(),
                etu.getId(),
                sm.getId(),
                updated.isEstCompleter(),
                updated.getDateCompletion()
        );
    }

    @Override
    public ProgressionResponse getProgressionById(Long id) {
        Progression progression = progressionRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Progression not found"));

        return new ProgressionResponse(
                progression.getId(),
                progression.getEtudiant().getId(),
                progression.getSousModule().getId(),
                progression.isEstCompleter(),
                progression.getDateCompletion()
        );
    }

    @Override
    public List<ProgressionResponse> getAllProgressions() {
        return progressionRepo.findAll().stream()
                .map(p -> new ProgressionResponse(
                        p.getId(),
                        p.getEtudiant().getId(),
                        p.getSousModule().getId(),
                        p.isEstCompleter(),
                        p.getDateCompletion()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProgression(Long id) {
        if (!progressionRepo.existsById(id)) {
            throw new EntityNotFoundException("Progression not found");
        }
        progressionRepo.deleteById(id);
    }
}
