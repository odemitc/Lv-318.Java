package org.uatransport.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.uatransport.entity.Stop;
import org.uatransport.entity.Transit;

public interface TransitRepository extends CrudRepository<Transit, Integer> {

  Transit findByName(String name);

  List<Transit> findByNameContaining(String name);

  List<Transit> findByCategoryName(String name);

  List<Transit> findByCategoryId(int id);

  List<Transit> findByStopsIn(@Param("stops") Stop... stops);
}
