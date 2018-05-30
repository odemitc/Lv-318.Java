package com.example.demo.service;

import com.example.demo.entity.ExtendableCategory;

import java.util.List;
import java.util.Optional;

public interface ExtendebleCategoryService {

    ExtendableCategory save(ExtendableCategory extendableCategory);

    void delete(ExtendableCategory extendableCategory);

    ExtendableCategory getByName(String name);

    List<ExtendableCategory> getListExtendableCategories();

    List<ExtendableCategory> getListTopExtendableCategories();

    List<ExtendableCategory> getByNextLevelCategoryId(Integer id);

    List<ExtendableCategory> getByNextLevelCategory(ExtendableCategory category);

    ExtendableCategory getByNameAndNextLevelCategory(String name, ExtendableCategory nextLevel);


}
