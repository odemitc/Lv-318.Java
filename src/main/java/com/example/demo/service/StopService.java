package com.example.demo.service;

import com.example.demo.entity.Stop;

import java.util.List;

public interface StopService {
    Stop addStop(Stop stop);

    Stop getById(Integer id);

    void delete(Integer id);

    Stop update(Stop stop);

    List<Stop> getStopsByStreet(String street);

}
