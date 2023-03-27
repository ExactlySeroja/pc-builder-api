package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Assembled;
import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class CpuController {
    @Autowired
    CpuService service;

    @GetMapping(value = "/components/cpu")
    public List<Cpu> list() {
        return service.listAll();
    }


    @GetMapping("/components/cpu/{id}")
    public ResponseEntity<Cpu> get(@PathVariable Integer id) {
        try {
            Cpu cpu = service.get(id);
            return new ResponseEntity<>(cpu, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/cpu")
    public ResponseEntity<?> add(@RequestBody Cpu cpu) {
        try {
            Cpu savedCpu = service.save(cpu);
            return new ResponseEntity<>(savedCpu, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/cpu/{id}")
    public ResponseEntity<?> update(@RequestBody Cpu cpu, @PathVariable Integer id) {
        service.update(cpu, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/cpu/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
