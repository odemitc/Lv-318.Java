package org.uatransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.uatransport.config.GlobalSearch;
import org.uatransport.entity.Stop;
import org.uatransport.entity.Transit;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TransitRepository extends CrudRepository<Transit, Integer>, JpaSpecificationExecutor<Transit> {

    Transit findByName(String name);

    List<Transit> findByNameContaining(String name);

    List<Transit> findByCategoryName(String name);

    List<Transit> findByCategoryId(int id);

    List<Transit> findByStopsIn(@Param("stops") Stop... stops);

}
