package org.uatransport.service;

import org.uatransport.entity.Point;

import java.util.List;

public interface PointService {
    Point save(Point stop);

    Point getById(Integer id);

    void delete(Integer id);

    Point update(Point stop);

    List<Point> getByTransitId(Integer id);

}
