package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Component;
import com.seroja.pcbuilderapp.repo.CaseRepository;
import com.seroja.pcbuilderapp.repo.ComponentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class CaseService {
    @Autowired
    private CaseRepository repo;

    public List<Case> listAll() {
        return repo.findAll();
    }

    public void save(Case pcCase){
        repo.save(pcCase);
    }
    public Case get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404),"Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
