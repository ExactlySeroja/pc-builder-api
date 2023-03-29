package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.CpuDto;
import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.mapper.CpuMapper;
import com.seroja.pcbuilderapp.repos.CpuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CpuService {
    private final CpuRepository repo;
    private final CpuMapper cpuMapper;

    public List<CpuDto> listAll() {
        return cpuMapper.toDtoList(repo.findAll());
    }

    public CpuDto save(CpuDto cpuDto) {
        return cpuMapper.toDto(repo.save(cpuMapper.toCpu(cpuDto)));
    }

    private Cpu get(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "CPU was not found!"));
    }

    public CpuDto getDto(int id) {
        return cpuMapper.toDto(repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "CPU was not found!")));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(CpuDto newCpuDto, int id) {
        Cpu exsistCpu = get(id);
        Cpu update = cpuMapper.toCpu(newCpuDto);
        cpuMapper.update(exsistCpu, update);
        repo.save(exsistCpu);
    }
}
