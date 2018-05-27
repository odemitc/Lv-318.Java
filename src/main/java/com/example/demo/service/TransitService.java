package com.example.demo.service;


import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.entity.Transit;

import java.util.List;

public interface TransitService {

    Transit addTransit(Transit transit);

    void delete(int id);

    void delete(Transit transit);

    Transit update(Transit transit);

    Transit getById(int id);

    Transit getByName(String name);

    List<Transit> getAllByCategory(NonExtendableCategory nonExtendableCategory);

    List<Transit> getAll();
}
