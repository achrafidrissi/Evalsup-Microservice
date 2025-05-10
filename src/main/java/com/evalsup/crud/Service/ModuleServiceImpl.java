package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.ModuleRequest;
import com.evalsup.crud.DTO.Response.ModuleResponse;
import com.evalsup.crud.Entity.Formation;
import com.evalsup.crud.Entity.Module;
import com.evalsup.crud.Repository.FormationRepository;
import com.evalsup.crud.Repository.ModuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImpl implements ModuleService{

    private final ModuleRepository moduleRepository;
    private final FormationRepository formationRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository, FormationRepository formationRepository) {
        this.moduleRepository = moduleRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public ModuleResponse createModule(ModuleRequest request) {
        Formation formation = formationRepository.findById(request.getFormationId())
                .orElseThrow(() -> new EntityNotFoundException("Formation not found"));

        Module module = new Module();
        module.setTitre(request.getTitre());
        module.setFormation(formation);

        Module saved = moduleRepository.save(module);
        return new ModuleResponse(saved.getId(), saved.getTitre(), saved.getFormation().getId());
    }

    @Override
    public ModuleResponse updateModule(Long id, ModuleRequest request) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Module not found"));

        Formation formation = formationRepository.findById(request.getFormationId())
                .orElseThrow(() -> new EntityNotFoundException("Formation not found"));

        module.setTitre(request.getTitre());
        module.setFormation(formation);

        Module updated = moduleRepository.save(module);
        return new ModuleResponse(updated.getId(), updated.getTitre(), updated.getFormation().getId());
    }

    @Override
    public ModuleResponse getModuleById(Long id) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Module not found"));

        return new ModuleResponse(module.getId(), module.getTitre(), module.getFormation().getId());
    }

    @Override
    public List<ModuleResponse> getAllModules() {
        return moduleRepository.findAll().stream()
                .map(m -> new ModuleResponse(m.getId(), m.getTitre(), m.getFormation().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteModule(Long id) {
        if (!moduleRepository.existsById(id)) {
            throw new EntityNotFoundException("Module not found");
        }
        moduleRepository.deleteById(id);
    }
}
