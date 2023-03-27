package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class PcCaseController {
    @Autowired
    CaseService service;

    @GetMapping(value = "/components/cases")
    public List<Case> list() {
        return service.listAll();
    }


    @GetMapping("/components/cases/{id}")
    public ResponseEntity<Case> get(@PathVariable Integer id) {
        try {
            Case pcCase = service.get(id);
            return new ResponseEntity<>(pcCase, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/cases")
    public ResponseEntity<?> add(@RequestBody Case pcCase) {
        try {
            Case savedPcCase = service.save(pcCase);
            return new ResponseEntity<>(savedPcCase, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/cases/{id}")
    public ResponseEntity<?> update(@RequestBody Case pcCase, @PathVariable Integer id) {
        service.update(pcCase, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/cases/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
