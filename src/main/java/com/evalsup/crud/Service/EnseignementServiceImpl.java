package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.EnseignementRequest;
import com.evalsup.crud.DTO.Response.EnseignementResponse;
import com.evalsup.crud.Entity.Enseignement;
import com.evalsup.crud.Entity.Professeur;
import com.evalsup.crud.Entity.SousModule;
import com.evalsup.crud.Repository.EnseignementRepository;
import com.evalsup.crud.Repository.ProfesseurRepository;
import com.evalsup.crud.Repository.SousModuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnseignementServiceImpl implements EnseignementService{

    private final EnseignementRepository enseignementRepository;
    private final ProfesseurRepository professeurRepository;
    private final SousModuleRepository sousModuleRepository;

    public EnseignementServiceImpl(EnseignementRepository enseignementRepository,
                                   ProfesseurRepository professeurRepository,
                                   SousModuleRepository sousModuleRepository) {
        this.enseignementRepository = enseignementRepository;
        this.professeurRepository = professeurRepository;
        this.sousModuleRepository = sousModuleRepository;
    }

    @Override
    public EnseignementResponse assignEnseignement(EnseignementRequest request) {
        Professeur prof = professeurRepository.findById(request.getProfesseurId())
                .orElseThrow(() -> new EntityNotFoundException("Professeur not found"));

        SousModule sm = sousModuleRepository.findById(request.getSousModuleId())
                .orElseThrow(() -> new EntityNotFoundException("SousModule not found"));

        Enseignement enseignement = new Enseignement();
        enseignement.setProfesseur(prof);
        enseignement.setSousModule(sm);

        Enseignement saved = enseignementRepository.save(enseignement);
        return new EnseignementResponse(saved.getId(), saved.getProfesseur().getId(), saved.getSousModule().getId());
    }

    @Override
    public EnseignementResponse updateEnseignement(Long id, EnseignementRequest request) {
        Enseignement ens = enseignementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enseignement not found"));

        Professeur prof = professeurRepository.findById(request.getProfesseurId())
                .orElseThrow(() -> new EntityNotFoundException("Professeur not found"));

        SousModule sm = sousModuleRepository.findById(request.getSousModuleId())
                .orElseThrow(() -> new EntityNotFoundException("SousModule not found"));

        ens.setProfesseur(prof);
        ens.setSousModule(sm);

        Enseignement updated = enseignementRepository.save(ens);
        return new EnseignementResponse(updated.getId(), prof.getId(), sm.getId());
    }

    @Override
    public EnseignementResponse getEnseignementById(Long id) {
        Enseignement ens = enseignementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enseignement not found"));

        return new EnseignementResponse(
                ens.getId(),
                ens.getProfesseur().getId(),
                ens.getSousModule().getId()
        );
    }

    @Override
    public List<EnseignementResponse> getAllEnseignements() {
        return enseignementRepository.findAll().stream()
                .map(e -> new EnseignementResponse(
                        e.getId(),
                        e.getProfesseur().getId(),
                        e.getSousModule().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEnseignement(Long professeurId, Long sousModuleId) {
        Enseignement enseignement = enseignementRepository
                .findByProfesseurIdAndSousModuleId(professeurId, sousModuleId)
                .orElseThrow(() -> new EntityNotFoundException("Enseignement not found"));
        enseignementRepository.delete(enseignement);
    }
}
