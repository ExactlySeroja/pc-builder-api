package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.RamDto;
import com.seroja.pcbuilderapp.service.RamService;
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
public class RamController {
    private final RamService service;

    @GetMapping(value = "/components/ram")
    public List<RamDto> list() {
        return service.listAll();
    }


    @GetMapping("/components/ram/{id}")
    public ResponseEntity<RamDto> get(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/ram")
    public ResponseEntity<?> add(@RequestBody @Valid RamDto ramDto) {
        try {
            return new ResponseEntity<>(service.save(ramDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/ram/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid RamDto ramDto, @PathVariable Integer id) {
        service.update(ramDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/ram/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
