package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.entities.Cpu;
import com.seroja.pcbuilderapp.entities.Drive;
import com.seroja.pcbuilderapp.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class DriveController {
    @Autowired
    DriveService service;

    @GetMapping(value = "/components/drives")
    public List<Drive> list() {
        return service.listAll();
    }


    @GetMapping("/components/drives/{id}")
    public ResponseEntity<Drive> get(@PathVariable Integer id) {
        try {
            Drive drive = service.get(id);
            return new ResponseEntity<>(drive, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/drives")
    public ResponseEntity<?> add(@RequestBody Drive drive) {
        try {
            Drive savedDrive = service.save(drive);
            return new ResponseEntity<>(savedDrive, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/drives/{id}")
    public ResponseEntity<?> update(@RequestBody Drive drive, @PathVariable Integer id) {
        service.update(drive, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/drives/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
