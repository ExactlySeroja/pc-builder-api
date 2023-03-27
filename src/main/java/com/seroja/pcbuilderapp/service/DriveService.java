package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Drive;
import com.seroja.pcbuilderapp.repo.DriveRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class DriveService {
    @Autowired
    private DriveRepository repo;

    public List<Drive> listAll() {
        return repo.findAll();
    }

    public Drive save(Drive drive) {
       return repo.save(drive);
    }

    public Drive get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(Drive newDrive, int id) {
        Drive driveToUpdate = get(id);
        driveToUpdate.setName(newDrive.getName());
        driveToUpdate.setPrice(newDrive.getPrice());
        repo.save(driveToUpdate);
    }

}
