package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.entities.PowerUnit;
import com.seroja.pcbuilderapp.service.PowerUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class PowerUnitController {
    @Autowired
    PowerUnitService service;

    @GetMapping(value = "/components/power-units")
    public List<PowerUnit> list() {
        return service.listAll();
    }


    @GetMapping("/components/power-units/{id}")
    public ResponseEntity<PowerUnit> get(@PathVariable Integer id) {
        try {
            PowerUnit powerUnit = service.get(id);
            return new ResponseEntity<>(powerUnit, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/power-units")
    public ResponseEntity<?> add(@RequestBody PowerUnit powerUnit) {
        try {
            PowerUnit savedPowerUnit = service.save(powerUnit);
            return new ResponseEntity<>(savedPowerUnit, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/power-units/{id}")
    public ResponseEntity<?> update(@RequestBody PowerUnit powerUnit, @PathVariable Integer id) {
        service.update(powerUnit, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/power-units/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
