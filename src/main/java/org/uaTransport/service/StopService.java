package org.uaTransport.service;

import org.uaTransport.entity.Stop;

import java.util.List;

public interface StopService {
    Stop addStop(Stop stop);

    Stop getById(Integer id);

    void delete(Integer id);

    Stop update(Stop stop);

    List<Stop> getStopsByStreet(String street);

}
