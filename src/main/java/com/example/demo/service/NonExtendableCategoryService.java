package com.example.demo.service;

import com.example.demo.entity.NonExtendableCategory;

import java.util.List;

public interface NonExtendableCategoryService {

    NonExtendableCategory addNonExtendableCategory(NonExtendableCategory nonExtendableCategory);

    void delete(int id);

    void delete(NonExtendableCategory nonExtendableCategory);

    NonExtendableCategory update(NonExtendableCategory nonExtendableCategory);

    NonExtendableCategory getByName(String name);

    List<NonExtendableCategory> getByNextLevelCategory(int id);

    NonExtendableCategory getById(Integer id);

}
