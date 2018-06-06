package org.uaTransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.uaTransport.entity.Stop;

import java.util.List;

public interface StopRepository extends CrudRepository<Stop, Integer> {

    List<Stop> findStopsByStreet(String name);

    }
