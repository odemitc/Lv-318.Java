package com.example.demo.service;

import com.example.demo.entity.Stop;
import com.example.demo.entity.Transit;

import java.util.List;

public interface TransitService {

    Transit addTransit(Transit transit);

    void delete(Integer id);

    void delete(Transit transit);

    Transit update(Transit transit);

    Transit getById(Integer id);

    Transit getByName(String name);

    List<Transit> getAllByCategoryName(String name);

    List<Transit> getAllByCategoryId(Integer id);

    List<Transit> getAll();

    List<Transit> getTransitsByStopsIn(Stop [] stops);


}
