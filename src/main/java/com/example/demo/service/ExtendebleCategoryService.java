package com.example.demo.service;

import com.example.demo.entity.ExtendableCategory;

import java.util.List;
import java.util.Optional;

public interface ExtendebleCategoryService {

    ExtendableCategory save(ExtendableCategory extendableCategory);

    void delete(ExtendableCategory extendableCategory);

    Optional<ExtendableCategory> findByName(String name);

    List<ExtendableCategory> listExtendableCategories();

    List<ExtendableCategory> findByNextLevelCategoryId(Integer id);

    List<ExtendableCategory> findByNextLevelCategory(ExtendableCategory category);


}
