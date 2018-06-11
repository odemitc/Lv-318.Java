package org.uatransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.uatransport.entity.Stop;

import java.util.List;

public interface StopRepository extends CrudRepository<Stop, Integer> {

    List<Stop> findByStreet(String name);

    }
