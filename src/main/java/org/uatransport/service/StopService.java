package org.uatransport.service;

import java.util.List;
import org.uatransport.entity.Stop;

public interface StopService {
  Stop save(Stop stop);

  Stop getById(Integer id);

  void delete(Integer id);

  Stop update(Stop stop);

  List<Stop> getByStreet(String street);

  List<Stop> getByTransitId(Integer id);

  Stop getByTransitIdAndStopName(Integer transitId, String street);

  Integer getIndexByTransitIdAndStopName(Integer transitId, String street);
}
