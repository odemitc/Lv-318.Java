package org.uatransport.service;

import org.uatransport.entity.Point;
import org.uatransport.entity.Stop;

import java.util.List;

public interface PointService {
    Point save(Point stop);

    Point getById(Integer id);

    void delete(Integer id);

    Point update(Point stop);

    List<Stop> getByStreet(String street);

    List<Stop> getStopsByTransitId(Integer id);

    Stop getByTransitIdAndStopName(Integer transitId, String street);

    Integer getIndexByTransitIdAndStopName(Integer transitId, String street);
}
