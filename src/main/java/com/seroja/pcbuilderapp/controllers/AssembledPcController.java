package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.AssembledDto;
import com.seroja.pcbuilderapp.dto.AssembledPcPriceRequest;
import com.seroja.pcbuilderapp.dto.PcBudgetRequest;
import com.seroja.pcbuilderapp.service.AssembledService;
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
public class AssembledPcController {

    private final AssembledService service;

    @GetMapping("/assembled")
    public List<AssembledDto> listAll() {
        return service.listAll();
    }

    @GetMapping("/assembled/{id}")
    public ResponseEntity<AssembledDto> getDto(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/assembled")
    public ResponseEntity<?> add(@RequestBody @Valid AssembledDto assembledDto) {
        try {
            return new ResponseEntity<>(service.save(assembledDto), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/assembled/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid AssembledDto assembledDto, @PathVariable Integer id) {
        service.updateDto(assembledDto, id);
        return ResponseEntity.ok("Successfully updated");
    }

    @DeleteMapping("/assembled/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(value = "/assembled/{id}/price", produces = {"application/json"})
    public ResponseEntity<AssembledPcPriceRequest> getAssembledPcPrice(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.calculateTotalPrice(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/assembled/build", produces = {"application/json"})
    public ResponseEntity<?> addBudgetPc(@RequestBody @Valid PcBudgetRequest pcBudgetRequest) {
        service.save(service.pickUpPcByBudget(pcBudgetRequest));
        return ResponseEntity.ok("Successfully build and added to DB");
    }
}
