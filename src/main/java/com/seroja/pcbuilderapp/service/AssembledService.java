package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Assembled;
import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.repo.AssembledRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class AssembledService {

    @Autowired
    AssembledRepository repo;

    public List<Assembled> listAll() {
        return repo.findAll();
    }

    public void save(Assembled assembled){
        repo.save(assembled);
    }
    public Assembled get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404),"Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public int calculateTotalPrice(int id){
       return repo.calculateTotalPrice(id);
    }

    public Assembled pickUpPcByBudget(int budget){

    }

}
