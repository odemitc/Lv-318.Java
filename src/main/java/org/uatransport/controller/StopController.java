package org.uatransport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.entity.Stop;
import org.uatransport.entity.Transit;
import org.uatransport.service.StopService;
import org.uatransport.service.TransitService;

import java.util.List;

@RestController
@RequestMapping("/stop")
@RequiredArgsConstructor
public class StopController {
    private final StopService stopService;
    private final TransitService transitService;

  @GetMapping("/{id}")
  public Stop getById(@PathVariable Integer id) {
    return stopService.getById(id);
  }

  @GetMapping(params = "street")
  public List<Stop> getByStreet(@RequestParam("street") String street) {
    return stopService.getByStreet(street);
  }

  @GetMapping(params = "transit-id")
  public List<Stop> getByTransitId(@RequestParam("transit-id") Integer id) {
    return stopService.getByTransitId(id);
  }

  @DeleteMapping("/{id}")
  public void deleteStop(@PathVariable Integer id) {
    stopService.delete(id);
  }

  @PostMapping("/{id}")
  public ResponseEntity<Stop> add(
      @RequestBody(required = false) Stop stop, @PathVariable Integer id) {
    Transit transitToUpdate = transitService.getById(id);
    transitToUpdate.getStops().add(stop);
    transitService.update(transitToUpdate);
    return new ResponseEntity<>(stopService.save(stop), HttpStatus.CREATED);
  }

//  @PutMapping("/{id}")
//  public ResponseEntity<Stop> update(@RequestBody Stop stop, @PathVariable Integer id) {
//    Stop savedStop = stopService.update(stop.setId(id));
//    return new ResponseEntity<>(savedStop, HttpStatus.CREATED);
//  }
}
