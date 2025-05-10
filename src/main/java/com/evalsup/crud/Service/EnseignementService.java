package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.EnseignementRequest;
import com.evalsup.crud.DTO.Response.EnseignementResponse;

import java.util.List;

public interface EnseignementService {

    EnseignementResponse assignEnseignement(EnseignementRequest request);
    EnseignementResponse updateEnseignement(Long id, EnseignementRequest request);
    EnseignementResponse getEnseignementById(Long id);
    List<EnseignementResponse> getAllEnseignements();
    void deleteEnseignement(Long professeurId, Long sousModuleId);
}
