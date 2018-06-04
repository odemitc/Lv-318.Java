package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Stop;
import com.example.demo.service.StopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/stop")
@RequiredArgsConstructor
public class StopController {

    private final StopService stopService;

//    @GetMapping
//    public ResponseEntity<List<Stop>> getAll() {
//        return new ResponseEntity<>(stopService.getAll(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Stop> getById(@PathVariable Integer id){
        Stop stop = stopService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Feedback with id '%s' not found", id)));
        return new ResponseEntity<>(stop, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStop(@PathVariable Integer id) {
        stopService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Stop> add(@RequestBody Stop stop) {
        Stop savedStop = stopService.addStop(stop);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStop.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Stop> update(@RequestBody Stop stop, @PathVariable Integer id) {
        Optional<Stop> stopOptional = stopService.getById(id);
        if (!stopOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        stop.setId(id);
        stopService.update(stop);
        return ResponseEntity.noContent().build();
    }

}
