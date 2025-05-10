package com.evalsup.crud.Service;

import com.evalsup.crud.DTO.Request.ProgressionRequest;
import com.evalsup.crud.DTO.Response.ProgressionResponse;

import java.util.List;

public interface ProgressionService {

    ProgressionResponse createProgression(ProgressionRequest request);
    ProgressionResponse updateProgression(Long id, ProgressionRequest request);
    ProgressionResponse getProgressionById(Long id);
    List<ProgressionResponse> getAllProgressions();
    void deleteProgression(Long id);
}
