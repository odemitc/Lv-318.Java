package com.example.demo.controller;

import com.example.demo.entity.Stop;
import com.example.demo.service.StopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stop")
@RequiredArgsConstructor
public class StopController {

    private final StopService stopService;

    @GetMapping("/{id}")
    public ResponseEntity<Stop> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(stopService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/street")
    public ResponseEntity<List<Stop>> getByStreet(@PathVariable String street) {
        return new ResponseEntity<>(stopService.getStopsByStreet(street), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStop(@PathVariable Integer id) {
        stopService.delete(id);
    }

    @PostMapping
    public ResponseEntity<Stop> add(@RequestBody Stop stop) {
        Stop savedStop = stopService.addStop(stop);
        return new ResponseEntity<>(savedStop, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stop> update(@RequestBody Stop stop, @PathVariable Integer id) {
        Stop savedStop = stopService.update(stop.setId(id));
        return  new ResponseEntity<>(savedStop, HttpStatus.CREATED);
    }

}
