package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.ProfesseurRequest;
import com.evalsup.crud.DTO.Response.ProfesseurResponse;

import java.util.List;

public interface ProfesseurService {

    ProfesseurResponse createProfesseur(ProfesseurRequest request);
    ProfesseurResponse updateProfesseur(Long id, ProfesseurRequest request);
    ProfesseurResponse getProfesseurById(Long id);
    List<ProfesseurResponse> getAllProfesseurs();
    void deleteProfesseur(Long id);
}
