package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.PowerUnitDto;
import com.seroja.pcbuilderapp.entities.PowerUnit;
import com.seroja.pcbuilderapp.mapper.PowerUnitMapper;
import com.seroja.pcbuilderapp.repos.PowerUnitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PowerUnitService {
    private final PowerUnitRepository repo;
    private final PowerUnitMapper powerUnitMapper;

    public List<PowerUnitDto> listAll() {
        return powerUnitMapper.toDtoList(repo.findAll());
    }

    public PowerUnitDto save(PowerUnitDto powerUnitDto) {
        return powerUnitMapper.toDto(repo.save(powerUnitMapper.toPowerUnit(powerUnitDto)));
    }

    public PowerUnit get(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Power Unit was not found!"));
    }

    public PowerUnitDto getDto(int id) {
        return powerUnitMapper.toDto(repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Power Unit was not found!")));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(PowerUnitDto newPowerUnitDto, int id) {
        PowerUnit exsistPowerUnit = get(id);
        PowerUnit update = powerUnitMapper.toPowerUnit(newPowerUnitDto);
        powerUnitMapper.update(exsistPowerUnit, update);
        repo.save(exsistPowerUnit);
    }

}
