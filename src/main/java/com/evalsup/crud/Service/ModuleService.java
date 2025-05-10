package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.ModuleRequest;
import com.evalsup.crud.DTO.Response.ModuleResponse;
import java.util.List;

public interface ModuleService {
    ModuleResponse createModule(ModuleRequest request);
    ModuleResponse updateModule(Long id, ModuleRequest request);
    ModuleResponse getModuleById(Long id);
    List<ModuleResponse> getAllModules();
    void deleteModule(Long id);
}
