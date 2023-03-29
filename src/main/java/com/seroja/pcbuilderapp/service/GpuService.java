package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.GpuDto;
import com.seroja.pcbuilderapp.entities.Gpu;
import com.seroja.pcbuilderapp.mapper.GpuMapper;
import com.seroja.pcbuilderapp.repos.GpuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GpuService {
    private final GpuRepository repo;
    private final GpuMapper gpuMapper;

    public List<GpuDto> listAll() {
        return gpuMapper.toDtoList(repo.findAll());
    }

    public GpuDto save(GpuDto gpuDto) {
        return gpuMapper.toDto(repo.save(gpuMapper.toGpu(gpuDto)));
    }

    public Gpu get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "GPU was not found"));
    }

    public GpuDto getDto(int id) {
        return gpuMapper.toDto(repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "GPU was not found")));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(GpuDto newGpuDto, int id) {
        Gpu exsistGpu = get(id);
        Gpu update = gpuMapper.toGpu(newGpuDto);
        gpuMapper.update(exsistGpu, update);
        repo.save(exsistGpu);
    }


}
