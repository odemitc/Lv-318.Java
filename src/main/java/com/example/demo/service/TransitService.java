package com.example.demo.service;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.entity.Transit;

import java.util.List;
import java.util.Optional;

public interface TransitService {

    Transit addTransit(Transit transit);

    void delete(int id);

    void delete(Transit transit);

    Transit update(Transit transit);

    Optional<Transit> getById(int id);

    Transit getByName(String name);

    List<Transit> getAllByCategory(NonExtendableCategory nonExtendableCategory);

    List<Transit> getAllByCategoryId(int id);

    List<Transit> getAll();
}
