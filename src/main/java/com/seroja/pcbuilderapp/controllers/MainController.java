package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Component;
import com.seroja.pcbuilderapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MainController {
    @Autowired
    private ComponentServiceImpl service;

    @GetMapping(value = "/components")
    public List<Component> list(){
        return service.listAll();
    }


    @GetMapping("/components/{id}")
    public ResponseEntity<Component> get(@PathVariable Integer id){
        try {
            Component component = service.get(id);
            return new ResponseEntity<>(component, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components")
    public ResponseEntity<?> add(@RequestBody Component component){
        service.save(component);
        return ResponseEntity.ok("Successfully added");
    }

    @PutMapping("/components/{id}")
    public ResponseEntity<?> update(@RequestBody Component component, @PathVariable Integer id){
        try {
            Component existComponent = service.get(id);
            service.save(component);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/components/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
