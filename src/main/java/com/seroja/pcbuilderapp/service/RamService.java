package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Ram;
import com.seroja.pcbuilderapp.repo.RamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class RamService {
    @Autowired
    private RamRepository repo;

    public List<Ram> listAll() {
        return repo.findAll();
    }

    public Ram save(Ram ram) {
        return repo.save(ram);
    }

    public Ram get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(Ram newRam, int id) {
        Ram ramToUpdate = get(id);
        ramToUpdate.setName(newRam.getName());
        ramToUpdate.setPrice(newRam.getPrice());
        ramToUpdate.setType(newRam.getType());
        repo.save(ramToUpdate);
    }

}
