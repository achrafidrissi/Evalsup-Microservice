package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.FormationRequest;
import com.evalsup.crud.DTO.Response.FormationResponse;

import java.util.List;

public interface FormationService {

    FormationResponse createFormation(FormationRequest request);
    FormationResponse updateFormation(Long id, FormationRequest request);
    FormationResponse getFormationById(Long id);
    List<FormationResponse> getAllFormations();
    void deleteFormation(Long id);
}
