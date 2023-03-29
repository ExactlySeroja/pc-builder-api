package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.RamDto;
import com.seroja.pcbuilderapp.entities.Ram;
import com.seroja.pcbuilderapp.mapper.RamMapper;
import com.seroja.pcbuilderapp.repos.RamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RamService {
    private final RamRepository repo;
    private final RamMapper ramMapper;

    public List<RamDto> listAll() {
        return ramMapper.toDtoList(repo.findAll());
    }

    public RamDto save(RamDto ramDto) {
        return ramMapper.toDto(repo.save(ramMapper.toRam(ramDto)));
    }

    private Ram get(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "RAM was not found!"));
    }

    public RamDto getDto(int id) {
        return ramMapper.toDto(repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "RAM was not found!")));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(RamDto newRamDto, int id) {
        Ram exsistRam = get(id);
        Ram update = ramMapper.toRam(newRamDto);
        ramMapper.update(exsistRam, update);
        repo.save(exsistRam);
    }

}
