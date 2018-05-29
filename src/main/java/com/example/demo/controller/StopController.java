package com.example.demo.controller;

import com.example.demo.entity.Stop;
import com.example.demo.service.StopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StopController {

    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping("/retrivestops")
    @ResponseStatus(HttpStatus.OK)
    public List<Stop> retrieveAllStops() {
        return stopService.getAll();
    }

    @GetMapping("/retrievestop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stop retrieveStop(@PathVariable Integer id) throws NoSuchFieldException {
        Optional<Stop> stop = stopService.getById(id);

        if (!stop.isPresent())
            throw new NoSuchFieldException("id-" + id);

        return stop.get();
    }

    @DeleteMapping("/deletestop/{id}")
    public void deleteStop(@PathVariable Integer id) {
        stopService.delete(id);
    }

    @PostMapping("/addstop")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Stop> createStudent(@RequestBody Stop stop) {
        Stop savedStudent = stopService.addStop(stop);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/updatestop/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Stop stop, @PathVariable Integer id) {
        Optional<Stop> stopOptional = stopService.getById(id);
        if (!stopOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        stop.setId(id);
        stopService.update(stop);
        return ResponseEntity.noContent().build();
    }

}
