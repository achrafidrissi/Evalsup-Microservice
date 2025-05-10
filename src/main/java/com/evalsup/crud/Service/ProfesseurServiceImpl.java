package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.ProfesseurRequest;
import com.evalsup.crud.DTO.Response.ProfesseurResponse;
import com.evalsup.crud.Entity.Professeur;
import com.evalsup.crud.Repository.ProfesseurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements ProfesseurService{

    private final ProfesseurRepository professeurRepository;

    public ProfesseurServiceImpl(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    @Override
    public ProfesseurResponse createProfesseur(ProfesseurRequest request) {
        Professeur prof = new Professeur();
        prof.setNom(request.getNom());
        prof.setEmail(request.getEmail());
        prof.setTelephone(request.getTelephone());
        prof.setPassword(request.getPassword());
        prof.setCodeProf(request.getCodeProf());

        Professeur saved = professeurRepository.save(prof);
        return new ProfesseurResponse(saved.getId(), saved.getNom(), saved.getEmail(), saved.getTelephone(), saved.getCodeProf());
    }

    @Override
    public ProfesseurResponse updateProfesseur(Long id, ProfesseurRequest request) {
        Professeur prof = professeurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professeur not found"));

        prof.setNom(request.getNom());
        prof.setEmail(request.getEmail());
        prof.setTelephone(request.getTelephone());
        prof.setPassword(request.getPassword());
        prof.setCodeProf(request.getCodeProf());

        Professeur updated = professeurRepository.save(prof);
        return new ProfesseurResponse(updated.getId(), updated.getNom(), updated.getEmail(), updated.getTelephone(), updated.getCodeProf());
    }

    @Override
    public ProfesseurResponse getProfesseurById(Long id) {
        Professeur prof = professeurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professeur not found"));
        return new ProfesseurResponse(prof.getId(), prof.getNom(), prof.getEmail(), prof.getTelephone(), prof.getCodeProf());
    }

    @Override
    public List<ProfesseurResponse> getAllProfesseurs() {
        return professeurRepository.findAll().stream()
                .map(prof -> new ProfesseurResponse(prof.getId(), prof.getNom(), prof.getEmail(), prof.getTelephone(), prof.getCodeProf()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProfesseur(Long id) {
        if (!professeurRepository.existsById(id)) {
            throw new EntityNotFoundException("Professeur not found");
        }
        professeurRepository.deleteById(id);
    }
}
