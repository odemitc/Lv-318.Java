package org.uaTransport.service;

import org.uaTransport.entity.ExtendableCategory;

import java.util.List;

public interface ExtendebleCategoryService {

    ExtendableCategory save(ExtendableCategory extendableCategory);

    void delete(ExtendableCategory extendableCategory);

    void delete(Integer id);

    ExtendableCategory update(ExtendableCategory category);

    ExtendableCategory getByName(String name);

    ExtendableCategory getById(Integer id);

    List<ExtendableCategory> getListExtendableCategories();

    List<ExtendableCategory> getListTopExtendableCategories();

    List<ExtendableCategory> getByNextLevelCategoryId(Integer id);

    List<ExtendableCategory> getByNextLevelCategory(ExtendableCategory category);

    ExtendableCategory getByNameAndNextLevelCategory(String name, ExtendableCategory nextLevel);
}
