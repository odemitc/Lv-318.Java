package com.example.demo.repository;

import com.example.demo.entity.Stop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StopRepository extends CrudRepository<Stop, Integer> {

    List<Stop> findStopsByStreet(String street);
    Stop findStopByBuilding(String building);

}
