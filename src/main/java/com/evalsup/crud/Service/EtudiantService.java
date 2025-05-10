package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.EtudiantRequest;
import com.evalsup.crud.DTO.Response.EtudiantResponse;

import java.util.List;

public interface EtudiantService {

    EtudiantResponse createEtudiant(EtudiantRequest request);
    EtudiantResponse updateEtudiant(Long id, EtudiantRequest request);
    EtudiantResponse getEtudiantById(Long id);
    List<EtudiantResponse> getAllEtudiants();
    void deleteEtudiant(Long id);
}