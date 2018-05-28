package com.example.demo.repository;

import com.example.demo.entity.NonExtendableCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonExtendableCategoryRepository extends JpaRepository<NonExtendableCategory, Integer> {

    NonExtendableCategory findByName(String name);

    NonExtendableCategory findByNextLevelCategoryId(int id);
}
