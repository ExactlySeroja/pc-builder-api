package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.entities.Component;
import com.seroja.pcbuilderapp.repo.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ComponentServiceImpl  {
    @Autowired
    private ComponentRepository repo;

    public List<Component> listAll() {
        return repo.findAll();
    }

    public void save(Component component){
        repo.save(component);
    }
    public Component get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404),"Something wrong"));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
