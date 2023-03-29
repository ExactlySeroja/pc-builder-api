package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.DriveDto;
import com.seroja.pcbuilderapp.service.DriveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class DriveController {

    private final DriveService service;

    @GetMapping(value = "/components/drives")
    public List<DriveDto> list() {
        return service.listAll();
    }


    @GetMapping("/components/drives/{id}")
    public ResponseEntity<DriveDto> getDto(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/drives")
    public ResponseEntity<?> add(@RequestBody @Valid DriveDto driveDto) {
        try {
            return new ResponseEntity<>(service.save(driveDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/drives/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid DriveDto driveDto, @PathVariable Integer id) {
        service.update(driveDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/drives/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
