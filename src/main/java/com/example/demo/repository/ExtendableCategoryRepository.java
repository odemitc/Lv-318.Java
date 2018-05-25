package com.example.demo.repository;

import com.example.demo.entity.ExtendableCategory;
import org.springframework.data.repository.CrudRepository;

public interface ExtendableCategoryRepository extends CrudRepository<ExtendableCategory, Integer> {
}
