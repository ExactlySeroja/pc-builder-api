package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.PowerUnit;
import com.seroja.pcbuilderapp.repo.PowerUnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PowerUnitService {
    @Autowired
    private PowerUnitRepository repo;

    public List<PowerUnit> listAll() {
        return repo.findAll();
    }

    public PowerUnit save(PowerUnit powerUnit) {
        return repo.save(powerUnit);
    }

    public PowerUnit get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(PowerUnit newPowerUnit, int id) {
        PowerUnit powerUnitToUpdate = get(id);
        powerUnitToUpdate.setName(newPowerUnit.getName());
        powerUnitToUpdate.setPrice(newPowerUnit.getPrice());
        save(powerUnitToUpdate);
    }

}
