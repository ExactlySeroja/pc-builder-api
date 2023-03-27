package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.repo.CpuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class CpuService {
    @Autowired
    private CpuRepository repo;

    public List<Cpu> listAll() {
        return repo.findAll();
    }

    public Cpu save(Cpu cpu) {
        return repo.save(cpu);
    }

    public Cpu get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(Cpu newCpu, int id) {
        Cpu cpuToUpdate = get(id);
        cpuToUpdate.setName(newCpu.getName());
        cpuToUpdate.setPrice(newCpu.getPrice());
        cpuToUpdate.setSocket(newCpu.getSocket());
        repo.save(cpuToUpdate);
    }
}
