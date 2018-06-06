package org.uaTransport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.uaTransport.entity.Stop;
import org.uaTransport.entity.Transit;

import java.util.List;

public interface TransitRepository extends CrudRepository<Transit, Integer> {

    Transit findByName(String name);

    List<Transit> findByNameContaining(String name);

    List<Transit> findByCategoryName(String name);

    List<Transit> findByCategoryId(int id);

    @Query("select t from Transit t join t.stops s where s.street in (:stops)")
    List<Transit> findTransitsByStopsIn(@Param("stops") Stop[] stops);

}
