package com.example.demo.service;

import com.example.demo.entity.NonExtendableCategory;

import java.util.List;
import java.util.Optional;

public interface NonExtendableCategoryService {

    NonExtendableCategory addNonExtendableCategory(NonExtendableCategory nonExtendableCategory);

    void delete(int id);

    void delete(NonExtendableCategory nonExtendableCategory);

    NonExtendableCategory update(NonExtendableCategory nonExtendableCategory);

    NonExtendableCategory getByName(String name);

    NonExtendableCategory getByNextLevelCategory(int id);

    Optional<NonExtendableCategory> getById(Integer id);

    List<NonExtendableCategory> getAll();
}
