package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.PowerUnitDto;
import com.seroja.pcbuilderapp.service.PowerUnitService;
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
public class PowerUnitController {
    private final PowerUnitService service;

    @GetMapping(value = "/components/power-units")
    public List<PowerUnitDto> list() {
        return service.listAll();
    }


    @GetMapping("/components/power-units/{id}")
    public ResponseEntity<PowerUnitDto> getDto(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/power-units")
    public ResponseEntity<?> add(@RequestBody @Valid PowerUnitDto powerUnitDto) {
        try {
            return new ResponseEntity<>(service.save(powerUnitDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/power-units/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid PowerUnitDto powerUnitDto, @PathVariable Integer id) {
        service.update(powerUnitDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/power-units/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
