package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.CaseDto;
import com.seroja.pcbuilderapp.service.CaseService;
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
public class PcCaseController {
    private final CaseService service;

    @GetMapping(value = "/components/cases")
    public List<CaseDto> list() {
        return service.listAll();
    }


    @GetMapping("/components/cases/{id}")
    public ResponseEntity<CaseDto> getDto(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/components/cases")
    public ResponseEntity<?> add(@RequestBody @Valid CaseDto pcCaseDto) {
        try {
            return new ResponseEntity<>(service.save(pcCaseDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/components/cases/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CaseDto pcCaseDto, @PathVariable Integer id) {
        service.update(pcCaseDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/components/cases/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
