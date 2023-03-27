package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.entities.Ram;
import com.seroja.pcbuilderapp.service.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class RamController {
    @Autowired
    RamService service;

    @GetMapping(value = "/components/ram")
    public List<Ram> list() {
        return service.listAll();
    }


    @GetMapping("/components/ram/{id}")
    public ResponseEntity<Ram> get(@PathVariable Integer id) {
        try {
            Ram ram = service.get(id);
            return new ResponseEntity<>(ram, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/ram")
    public ResponseEntity<?> add(@RequestBody Ram ram) {
        try {
            Ram savedRam = service.save(ram);
            return new ResponseEntity<>(savedRam, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/ram/{id}")
    public ResponseEntity<?> update(@RequestBody Ram ram, @PathVariable Integer id) {
        service.update(ram, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/ram/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
