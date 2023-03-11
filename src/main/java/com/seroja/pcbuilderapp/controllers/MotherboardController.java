package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Motherboard;
import com.seroja.pcbuilderapp.service.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
public class MotherboardController {
    @Autowired
    MotherboardService service;
    @GetMapping(value = "/components/motherboard")
    public List<Motherboard> list(){
        return service.listAll();
    }


    @GetMapping("/components/motherboard/{id}")
    public ResponseEntity<Motherboard> get(@PathVariable Integer id){
        try {
            Motherboard motherboard = service.get(id);
            return new ResponseEntity<>(motherboard, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/motherboard")
    public ResponseEntity<?> add(@RequestBody Motherboard motherboard){
        service.save(motherboard);
        return ResponseEntity.ok("Successfully added");
    }

    @PutMapping("/components/motherboard/{id}")
    public ResponseEntity<?> update(@RequestBody Motherboard motherboard, @PathVariable Integer id){
        try {
            Motherboard existMotherboard = service.get(id);
            service.save(motherboard);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/components/motherboard/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }


}
