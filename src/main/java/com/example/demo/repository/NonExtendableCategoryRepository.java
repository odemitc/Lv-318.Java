package com.example.demo.repository;

import com.example.demo.entity.NonExtendableCategory;
import org.springframework.data.repository.CrudRepository;

public interface NonExtendableCategoryRepository extends CrudRepository<NonExtendableCategory, Integer> {
}
