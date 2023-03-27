package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Gpu;
import com.seroja.pcbuilderapp.service.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class GpuController {
    @Autowired
    GpuService service;

    @GetMapping(value = "/components/gpu")
    public List<Gpu> list() {
        return service.listAll();
    }


    @GetMapping("/components/gpu/{id}")
    public ResponseEntity<Gpu> get(@PathVariable Integer id) {
        try {
            Gpu gpu = service.get(id);
            return new ResponseEntity<>(gpu, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/components/gpu")
    public ResponseEntity<?> add(@RequestBody Gpu gpu) {
        try {
            Gpu savedGpu = service.save(gpu);
            return new ResponseEntity<>(savedGpu, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/gpu/{id}")
    public ResponseEntity<?> update(@RequestBody Gpu gpu, @PathVariable Integer id) {
        service.update(gpu, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/gpu/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
