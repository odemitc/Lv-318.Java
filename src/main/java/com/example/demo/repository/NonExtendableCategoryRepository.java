package com.example.demo.repository;

import com.example.demo.entity.NonExtendableCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonExtendableCategoryRepository extends JpaRepository<NonExtendableCategory, Integer> {

    NonExtendableCategory findByName(String name);

    List<NonExtendableCategory> findByNextLevelCategoryId(int id);
}
