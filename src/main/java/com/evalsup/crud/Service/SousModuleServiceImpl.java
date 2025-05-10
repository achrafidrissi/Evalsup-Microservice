package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.SousModuleRequest;
import com.evalsup.crud.DTO.Response.SousModuleResponse;
import com.evalsup.crud.Entity.SousModule;
import com.evalsup.crud.Entity.Module;
import com.evalsup.crud.Repository.ModuleRepository;
import com.evalsup.crud.Repository.SousModuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SousModuleServiceImpl implements SousModuleService{

    private final SousModuleRepository sousModuleRepository;
    private final ModuleRepository moduleRepository;

    public SousModuleServiceImpl(SousModuleRepository sousModuleRepository, ModuleRepository moduleRepository) {
        this.sousModuleRepository = sousModuleRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public SousModuleResponse createSousModule(SousModuleRequest request) {
        Module module = moduleRepository.findById(request.getModuleId())
                .orElseThrow(() -> new EntityNotFoundException("Module not found"));

        SousModule sm = new SousModule();
        sm.setTitre(request.getTitre());
        sm.setModule(module);

        SousModule saved = sousModuleRepository.save(sm);
        return new SousModuleResponse(saved.getId(), saved.getTitre(), module.getId());
    }

    @Override
    public SousModuleResponse updateSousModule(Long id, SousModuleRequest request) {
        SousModule sm = sousModuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SousModule not found"));

        Module module = moduleRepository.findById(request.getModuleId())
                .orElseThrow(() -> new EntityNotFoundException("Module not found"));

        sm.setTitre(request.getTitre());
        sm.setModule(module);

        SousModule updated = sousModuleRepository.save(sm);
        return new SousModuleResponse(updated.getId(), updated.getTitre(), module.getId());
    }

    @Override
    public SousModuleResponse getSousModuleById(Long id) {
        SousModule sm = sousModuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SousModule not found"));

        return new SousModuleResponse(sm.getId(), sm.getTitre(), sm.getModule().getId());
    }

    @Override
    public List<SousModuleResponse> getAllSousModules() {
        return sousModuleRepository.findAll().stream()
                .map(sm -> new SousModuleResponse(sm.getId(), sm.getTitre(), sm.getModule().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSousModule(Long id) {
        if (!sousModuleRepository.existsById(id)) {
            throw new EntityNotFoundException("SousModule not found");
        }
        sousModuleRepository.deleteById(id);
    }

}
