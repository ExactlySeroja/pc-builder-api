package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.GpuDto;
import com.seroja.pcbuilderapp.service.GpuService;
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
public class GpuController {
    private final GpuService service;

    @GetMapping(value = "/components/gpu")
    public List<GpuDto> list() {
        return service.listAll();
    }


    @GetMapping("/components/gpu/{id}")
    public ResponseEntity<GpuDto> getDto(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/gpu")
    public ResponseEntity<?> add(@RequestBody @Valid GpuDto gpuDto) {
        try {
            return new ResponseEntity<>(service.save(gpuDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/gpu/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid GpuDto gpuDto, @PathVariable Integer id) {
        service.update(gpuDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/gpu/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
