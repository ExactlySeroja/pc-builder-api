package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.MotherboardDto;
import com.seroja.pcbuilderapp.service.MotherboardService;
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
public class MotherboardController {
    private final MotherboardService service;

    @GetMapping(value = "/components/motherboards")
    public List<MotherboardDto> list() {
        return service.listAll();
    }


    @GetMapping("/components/motherboards/{id}")
    public ResponseEntity<MotherboardDto> get(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/motherboards")
    public ResponseEntity<?> add(@RequestBody @Valid MotherboardDto motherboardDto) {
        try {
            return new ResponseEntity<>(service.save(motherboardDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/motherboards/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid MotherboardDto motherboardDto, @PathVariable Integer id) {
        service.updateMotherboard(motherboardDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/motherboards/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
