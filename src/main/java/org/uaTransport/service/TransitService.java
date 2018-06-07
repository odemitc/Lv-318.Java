package org.uaTransport.service;

import org.uaTransport.entity.Stop;
import org.uaTransport.entity.Transit;

import java.util.List;

public interface TransitService {

    Transit addTransit(Transit transit);

    void delete(Integer id);

    void delete(Transit transit);

    Transit update(Transit transit);

    Transit getById(Integer id);

    Transit getByName(String name);

    List<Transit> getAllByCategoryId(Integer id);

    List<Transit> getAll();

    List<Transit> getTransitsByStopsIn(Stop[] stops);

}
