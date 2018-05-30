package com.example.demo.controller;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entity.Transit;
import com.example.demo.service.TransitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/transit")
@RequiredArgsConstructor
public class TransitController {

    private final TransitService transitService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Transit> getTransit(@PathVariable Integer id) {
        Transit transit = transitService.getById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String.format("Transit with id '%s' not found", id)));

        return new ResponseEntity<>(transit, HttpStatus.OK);
    }

    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<Transit>> getAllTransits() {
        return new ResponseEntity<>(transitService.getAll(), HttpStatus.OK);
    }
}