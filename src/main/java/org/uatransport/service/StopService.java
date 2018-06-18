package org.uatransport.service;

import org.uatransport.entity.Stop;

import java.util.List;

public interface StopService {
    Stop save(Stop stop);

    Stop getById(Integer id);

    void delete(Integer id);

    Stop update(Stop stop);

    List<Stop> getByStreet(String street);

    List<Stop> getByTransitId(Integer id);

    Stop getByTransitIdAndStopName(Integer transitId, String street);

    Integer getIndexByTransitIdAndStopName(Integer transitId, String street);

    List<Stop> getByTransidIdWhereStreetNotNull(Integer id);
}
