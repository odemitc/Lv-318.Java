package org.uatransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.uatransport.entity.Stop;
import org.uatransport.entity.Transit;

import java.util.List;

public interface TransitRepository extends CrudRepository<Transit, Integer> {

    Transit findByName(String name);

    List<Transit> findByNameContaining(String name);

    List<Transit> findByCategoryName(String name);

    List<Transit> findByCategoryId(int id);

    List<Transit> findByStopsIn(@Param("stops") Stop... stops);

}
