package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Motherboard;
import com.seroja.pcbuilderapp.repo.MotherboardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class MotherboardService {
    @Autowired
    private MotherboardRepository repo;

    public List<Motherboard> listAll() {
        return repo.findAll();
    }

    public Motherboard save(Motherboard motherboard) {
       return repo.save(motherboard);
    }

    public Motherboard get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Something wrong"));
    }

    public void updateMotherboard(Motherboard newMotherboard, int id) {
        Motherboard mbToUpdate = get(id);
        mbToUpdate.setName(newMotherboard.getName());
        mbToUpdate.setPrice(newMotherboard.getPrice());
        mbToUpdate.setSocket(newMotherboard.getSocket());
        mbToUpdate.setRamSlot(newMotherboard.getRamSlot());
        repo.save(mbToUpdate);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
