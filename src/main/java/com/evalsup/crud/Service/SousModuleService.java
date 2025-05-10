package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.SousModuleRequest;
import com.evalsup.crud.DTO.Response.SousModuleResponse;
import java.util.List;

public interface SousModuleService {

    SousModuleResponse createSousModule(SousModuleRequest request);
    SousModuleResponse updateSousModule(Long id, SousModuleRequest request);
    SousModuleResponse getSousModuleById(Long id);
    List<SousModuleResponse> getAllSousModules();
    void deleteSousModule(Long id);
}
