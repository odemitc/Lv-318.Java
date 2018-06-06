package org.uaTransport.repository;

import org.uaTransport.entity.Stop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StopRepository extends CrudRepository<Stop, Integer> {

    List<Stop> findStopsByStreet(String name);

}
