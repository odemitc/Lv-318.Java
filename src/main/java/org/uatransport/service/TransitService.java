package org.uatransport.service;

import java.util.List;
import org.uatransport.entity.Stop;
import org.uatransport.entity.Transit;

public interface TransitService {

  Transit add(Transit transit);

  void delete(Integer id);

  void delete(Transit transit);

  Transit update(Transit transit);

  Transit getById(Integer id);

  Transit getByName(String name);

  List<Transit> getAllByCategoryId(Integer id);

  List<Transit> getAll();

  List<Transit> getTransitsByStopsIn(Stop[] stops);
}
