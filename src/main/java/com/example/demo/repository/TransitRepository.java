package com.example.demo.repository;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.entity.Stop;
import com.example.demo.entity.Transit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransitRepository extends CrudRepository<Transit, Integer> {

    Transit findByName(String name);

    List<Transit> findByNameContaining(String name);

    List<Transit> findTransitsByCategory(NonExtendableCategory nonExtendableCategory);

    List<Transit> findTransitsByCategoryId(int id);

    @Query("select t from Transit t join t.stops s where s.street in (:stops)")
    List<Transit> findTransitsByStopsIn(@Param("stops") Stop [] stops);


    }
