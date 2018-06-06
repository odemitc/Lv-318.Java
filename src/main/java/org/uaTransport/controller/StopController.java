package org.uaTransport.controller;

import org.uaTransport.entity.Stop;
import org.uaTransport.service.StopService;
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

    @GetMapping("/get/{street}")
    public ResponseEntity<List<Stop>> getByStreet(@PathVariable (value = "street") String street) {
        return new ResponseEntity<>(stopService.getStopsByStreet(street), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStop(@PathVariable Integer id) {
        stopService.delete(id);
    }


    @PostMapping
    public ResponseEntity<Stop> add(@RequestBody(required = false) Stop stop) {
        Stop savedStop = stopService.addStop(stop);
        return new ResponseEntity<>(stopService.addStop(stop), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stop> update(@RequestBody Stop stop, @PathVariable Integer id) {
        Stop savedStop = stopService.update(stop.setId(id));
        return  new ResponseEntity<>(savedStop, HttpStatus.CREATED);
    }

}
