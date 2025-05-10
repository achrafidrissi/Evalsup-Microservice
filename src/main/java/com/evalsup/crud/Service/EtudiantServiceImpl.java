package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.EtudiantRequest;
import com.evalsup.crud.DTO.Response.EtudiantResponse;
import com.evalsup.crud.Entity.Etudiant;
import com.evalsup.crud.Repository.EtudiantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantServiceImpl implements EtudiantService{

    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public EtudiantResponse createEtudiant(EtudiantRequest request) {
        Etudiant etu = new Etudiant();
        etu.setNom(request.getNom());
        etu.setEmail(request.getEmail());
        etu.setTelephone(request.getTelephone());
        etu.setPassword(request.getPassword());
        etu.setCodeEtu(request.getCodeEtu());

        Etudiant saved = etudiantRepository.save(etu);
        return new EtudiantResponse(saved.getId(), saved.getNom(), saved.getEmail(), saved.getTelephone(), saved.getCodeEtu());
    }

    @Override
    public EtudiantResponse updateEtudiant(Long id, EtudiantRequest request) {
        Etudiant etu = etudiantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etudiant not found"));

        etu.setNom(request.getNom());
        etu.setEmail(request.getEmail());
        etu.setTelephone(request.getTelephone());
        etu.setPassword(request.getPassword());
        etu.setCodeEtu(request.getCodeEtu());

        Etudiant updated = etudiantRepository.save(etu);
        return new EtudiantResponse(updated.getId(), updated.getNom(), updated.getEmail(), updated.getTelephone(), updated.getCodeEtu());
    }

    @Override
    public EtudiantResponse getEtudiantById(Long id) {
        Etudiant etu = etudiantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etudiant not found"));
        return new EtudiantResponse(etu.getId(), etu.getNom(), etu.getEmail(), etu.getTelephone(), etu.getCodeEtu());
    }

    @Override
    public List<EtudiantResponse> getAllEtudiants() {
        return etudiantRepository.findAll().stream()
                .map(etu -> new EtudiantResponse(etu.getId(), etu.getNom(), etu.getEmail(), etu.getTelephone(), etu.getCodeEtu()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEtudiant(Long id) {
        if (!etudiantRepository.existsById(id)) {
            throw new EntityNotFoundException("Etudiant not found");
        }
        etudiantRepository.deleteById(id);
    }
}
