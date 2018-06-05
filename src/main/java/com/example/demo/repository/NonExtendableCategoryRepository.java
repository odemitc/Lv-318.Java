package com.example.demo.repository;

import com.example.demo.entity.NonExtendableCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NonExtendableCategoryRepository extends JpaRepository<NonExtendableCategory, Integer> {

    List<NonExtendableCategory> findByNextLevelCategoryId(int id);

<<<<<<< HEAD
=======
    List<NonExtendableCategory> findByNextLevelCategoryNameAndNextLevelCategoryNextLevelCategoryName(String top, String next);
>>>>>>> ac089be09ceca9597bc2c38c5f33da7eabf9504f
}
