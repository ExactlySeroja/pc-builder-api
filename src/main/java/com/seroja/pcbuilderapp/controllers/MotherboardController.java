package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.entities.Motherboard;
import com.seroja.pcbuilderapp.service.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class MotherboardController {
    @Autowired
    MotherboardService service;

    @GetMapping(value = "/components/motherboards")
    public List<Motherboard> list() {
        return service.listAll();
    }


    @GetMapping("/components/motherboards/{id}")
    public ResponseEntity<Motherboard> get(@PathVariable Integer id) {
        try {
            Motherboard motherboard = service.get(id);
            return new ResponseEntity<>(motherboard, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/motherboards")
    public ResponseEntity<?> add(@RequestBody Motherboard motherboard) {
        try {
            Motherboard savedMotherboard = service.save(motherboard);
            return new ResponseEntity<>(savedMotherboard, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/motherboards/{id}")
    public ResponseEntity<?> update(@RequestBody Motherboard motherboard, @PathVariable Integer id) {
        service.updateMotherboard(motherboard, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/motherboards/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
