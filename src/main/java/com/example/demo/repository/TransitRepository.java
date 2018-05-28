package com.example.demo.repository;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.entity.Transit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransitRepository extends CrudRepository<Transit, Integer> {

    Transit findByName(String name);

    List<Transit> findByNameContaining(String name);

    List<Transit> findTransitsByCategory(NonExtendableCategory nonExtendableCategory);

    List<Transit> findTransitsByCategoryId(int id);
}
