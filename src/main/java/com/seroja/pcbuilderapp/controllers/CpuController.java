package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.CpuDto;
import com.seroja.pcbuilderapp.service.CpuService;
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
public class CpuController {
    private final CpuService service;

    @GetMapping(value = "/components/cpu")
    public List<CpuDto> list() {
        return service.listAll();
    }


    @GetMapping("/components/cpu/{id}")
    public ResponseEntity<CpuDto> get(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/cpu")
    public ResponseEntity<?> add(@RequestBody @Valid CpuDto cpuDto) {
        try {
            return new ResponseEntity<>(service.save(cpuDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/cpu/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CpuDto cpuDto, @PathVariable Integer id) {
        service.update(cpuDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/cpu/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
