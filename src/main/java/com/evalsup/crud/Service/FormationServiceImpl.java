package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.FormationRequest;
import com.evalsup.crud.DTO.Response.FormationResponse;
import com.evalsup.crud.Entity.Formation;
import com.evalsup.crud.Repository.FormationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;

    public FormationServiceImpl(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    @Override
    public FormationResponse createFormation(FormationRequest request) {
        Formation formation = new Formation();
        formation.setTitre(request.getTitre());
        Formation saved = formationRepository.save(formation);
        return new FormationResponse(saved.getId(), saved.getTitre());
    }

    @Override
    public FormationResponse updateFormation(Long id, FormationRequest request) {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formation not found"));
        formation.setTitre(request.getTitre());
        Formation updated = formationRepository.save(formation);
        return new FormationResponse(updated.getId(), updated.getTitre());
    }

    @Override
    public FormationResponse getFormationById(Long id) {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formation not found"));
        return new FormationResponse(formation.getId(), formation.getTitre());
    }

    @Override
    public List<FormationResponse> getAllFormations() {
        return formationRepository.findAll().stream()
                .map(f -> new FormationResponse(f.getId(), f.getTitre()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFormation(Long id) {
        if (!formationRepository.existsById(id)) {
            throw new EntityNotFoundException("Formation not found");
        }
        formationRepository.deleteById(id);
    }
}
