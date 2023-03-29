package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.MotherboardDto;
import com.seroja.pcbuilderapp.entities.Motherboard;
import com.seroja.pcbuilderapp.mapper.MotherboardMapper;
import com.seroja.pcbuilderapp.repos.MotherboardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MotherboardService {
    private final MotherboardRepository repo;
    private final MotherboardMapper motherboardMapper;

    public List<MotherboardDto> listAll() {
        return motherboardMapper.toDtoList(repo.findAll());
    }

    public MotherboardDto save(MotherboardDto motherboardDto) {
        return motherboardMapper.toDto(repo.save(motherboardMapper.toMotherboard(motherboardDto)));
    }

    public Motherboard get(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Motherboard was not found!"));
    }

    public MotherboardDto getDto(int id) {
        return motherboardMapper.toDto(repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Motherboard was not found!")));
    }

    public void updateMotherboard(MotherboardDto newMotherboardDto, int id) {
        Motherboard exsistMotherboard = get(id);
        Motherboard update = motherboardMapper.toMotherboard(newMotherboardDto);
        motherboardMapper.update(exsistMotherboard, update);
        repo.save(exsistMotherboard);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
