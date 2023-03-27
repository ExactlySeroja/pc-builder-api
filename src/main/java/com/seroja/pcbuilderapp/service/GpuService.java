package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Gpu;
import com.seroja.pcbuilderapp.repo.GpuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class GpuService {
    @Autowired
    private GpuRepository repo;

    public List<Gpu> listAll() {
        return repo.findAll();
    }

    public Gpu save(Gpu gpu) {
        return repo.save(gpu);
    }

    public Gpu get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(Gpu newGpu, int id) {
        Gpu gpuToUpdate = get(id);
        gpuToUpdate.setName(newGpu.getName());
        gpuToUpdate.setPrice(newGpu.getPrice());
        repo.save(gpuToUpdate);
    }


}
