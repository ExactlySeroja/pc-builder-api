package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.PowerUnit;
import com.seroja.pcbuilderapp.service.PowerUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
public class PowerUnitController {
    @Autowired
    PowerUnitService service;
    @GetMapping(value = "/components/power-unit")
    public List<PowerUnit> list(){
        return service.listAll();
    }


    @GetMapping("/components/power-unit/{id}")
    public ResponseEntity<PowerUnit> get(@PathVariable Integer id){
        try {
            PowerUnit powerUnit = service.get(id);
            return new ResponseEntity<>(powerUnit, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/power-unit")
    public ResponseEntity<?> add(@RequestBody PowerUnit powerUnit){
        service.save(powerUnit);
        return ResponseEntity.ok("Successfully added");
    }

    @PutMapping("/components/power-unit/{id}")
    public ResponseEntity<?> update(@RequestBody PowerUnit powerUnit, @PathVariable Integer id){
        try {
            PowerUnit existPowerUnit = service.get(id);
            service.save(powerUnit);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/components/power-unit/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
