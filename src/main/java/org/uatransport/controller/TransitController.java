package org.uatransport.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.entity.Transit;
import org.uatransport.entity.dto.TransitDTO;
import org.uatransport.service.TransitService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transit")
@RequiredArgsConstructor
public class TransitController {
    private final TransitService transitService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public TransitDTO getTransitById(@PathVariable Integer id) {
        return modelMapper.map(transitService.getById(id), TransitDTO.class);
    }

    @GetMapping
    public List<TransitDTO> getAllTransits() {
        return transitService
            .getAll()
            .stream()
            .map(transit -> modelMapper.map(transit, TransitDTO.class))
            .collect(Collectors.toList());
    }

    @GetMapping(params = "categoryId")
    public List<TransitDTO> getTransitsByCategoryId(
        @RequestParam("categoryId") Integer categoryId) {
        return transitService
            .getAllByCategoryId(categoryId)
            .stream()
            .map(transit -> modelMapper.map(transit, TransitDTO.class))
            .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Transit> addTransit(@RequestBody TransitDTO transitDTO) {
        Transit transit = modelMapper.map(transitDTO, Transit.class);
        return new ResponseEntity<>(transitService.add(transit), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTransit(@PathVariable Integer id) {
        transitService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transit> updateTransit(
        @RequestBody TransitDTO transitDTO, @PathVariable Integer id) {
        Transit updatedTransit =
            transitService.update(modelMapper.map(transitDTO, Transit.class).setId(id));
        return new ResponseEntity<>(updatedTransit, HttpStatus.OK);
    }
}
