package com.example.demo.service;

import com.example.demo.entity.Stop;

import java.util.List;
import java.util.Optional;

public interface StopService {
    Stop addStop(Stop stop);

    Optional<Stop> getById(Integer id);

    void delete(Integer id);

    Stop update(Stop stop);

    List<Stop> getStopByStreet(String street);

    List<Stop> getAll();
    Stop getStopByBuilding(String building);


}
