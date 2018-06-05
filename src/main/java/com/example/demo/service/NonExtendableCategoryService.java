package com.example.demo.service;

import com.example.demo.entity.NonExtendableCategory;

import java.util.List;

public interface NonExtendableCategoryService {

    NonExtendableCategory addNonExtendableCategory(NonExtendableCategory nonExtendableCategory);

    void delete(int id);

    NonExtendableCategory update(NonExtendableCategory nonExtendableCategory);

    List<NonExtendableCategory> getByNextLevelCategory(int id);

    NonExtendableCategory getById(Integer id);

    List<NonExtendableCategory> getByNames(String name,String next);
}
