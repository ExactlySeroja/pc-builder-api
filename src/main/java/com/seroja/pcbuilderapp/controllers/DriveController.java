package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Drive;
import com.seroja.pcbuilderapp.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
public class DriveController {
    @Autowired
    DriveService service;
    @GetMapping(value = "/components/drive")
    public List<Drive> list(){
        return service.listAll();
    }


    @GetMapping("/components/drive/{id}")
    public ResponseEntity<Drive> get(@PathVariable Integer id){
        try {
            Drive drive = service.get(id);
            return new ResponseEntity<>(drive, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/drive")
    public ResponseEntity<?> add(@RequestBody Drive drive){
        service.save(drive);
        return ResponseEntity.ok("Successfully added");
    }

    @PutMapping("/components/drive/{id}")
    public ResponseEntity<?> update(@RequestBody Drive drive, @PathVariable Integer id){
        try {
            Drive existDrive = service.get(id);
            service.save(drive);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/components/drive/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }


}
