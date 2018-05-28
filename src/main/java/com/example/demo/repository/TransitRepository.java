package com.example.demo.repository;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.entity.Transit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransitRepository extends JpaRepository<Transit, Integer> {

    Transit findByName(String name);

    List<Transit> findByNameContaining(String name);

    List<Transit> findTransitsByCategory(NonExtendableCategory nonExtendableCategory);

    List<Transit> findTransitsByCategoryId(int id);
}
