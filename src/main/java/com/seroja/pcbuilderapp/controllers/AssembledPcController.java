package com.seroja.pcbuilderapp.controllers;

import com.seroja.pcbuilderapp.dto.AssembledDto;
import com.seroja.pcbuilderapp.dto.PcBudgetRequest;
import com.seroja.pcbuilderapp.entities.Assembled;
import com.seroja.pcbuilderapp.service.AssembledService;
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

    private  final AssembledService service;

    @GetMapping("/assembled")
    public List<AssembledDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/assembled/{id}")
    public ResponseEntity<Assembled> get(@PathVariable int id) {
        try {
            Assembled assembled = service.get(id);
            return new ResponseEntity<>(assembled, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/assembled")
    public ResponseEntity<?> add(@RequestBody AssembledDto assembledDto) {
        try {
            service.saveDto(assembledDto);
            return new ResponseEntity<>(assembledDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/assembled/{id}")
    public ResponseEntity<?> update(@RequestBody AssembledDto assembledDto, @PathVariable Integer id) {
        service.updateDto(assembledDto, id);
        return ResponseEntity.ok("Successfully updated");
    }

    @DeleteMapping("/assembled/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/assembled/{id}/price")
    public int getAssembledPcPrice(@PathVariable int id) {
        return service.calculateTotalPrice(id);
    }

    @PostMapping(value = "/assembled/build", produces = {"application/json"})
    public ResponseEntity<?> addBudgetPc(@RequestBody PcBudgetRequest pcBudgetRequest) {
        service.save(service.pickUpPcByBudget(pcBudgetRequest));
        return ResponseEntity.ok("Successfully build and added to DB");
    }
}
