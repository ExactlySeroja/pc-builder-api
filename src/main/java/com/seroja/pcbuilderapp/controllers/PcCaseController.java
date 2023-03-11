package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
public class PcCaseController {
    @Autowired
    CaseService service;
    @GetMapping(value = "/components/case")
    public List<Case> list(){
        return service.listAll();
    }


    @GetMapping("/components/case/{id}")
    public ResponseEntity<Case> get(@PathVariable Integer id){
        try {
            Case pcCase = service.get(id);
            return new ResponseEntity<>(pcCase, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/case")
    public ResponseEntity<?> add(@RequestBody Case pcCase){
        service.save(pcCase);
        return ResponseEntity.ok("Successfully added");
    }

    @PutMapping("/components/case/{id}")
    public ResponseEntity<?> update(@RequestBody Case pcCase, @PathVariable Integer id){
        try {
            Case existpcCase = service.get(id);
            service.save(pcCase);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/components/case/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }


}
