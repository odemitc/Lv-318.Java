package org.uatransport.service;

import org.uatransport.entity.ExtendableCategory;
import org.uatransport.entity.NonExtendableCategory;
import org.uatransport.entity.dto.NonExtendableCategoryDto;

import java.util.List;

public interface CategoryService {

    ExtendableCategory save(ExtendableCategory category);

    void delete(Integer id);

    ExtendableCategory update(ExtendableCategory category);

    ExtendableCategory getById(Integer id);

    List<ExtendableCategory> getByNextLevelCategoryId(Integer id);

    NonExtendableCategory addNonExtendableCategory(NonExtendableCategoryDto nonExtendableCategory);

    List<NonExtendableCategory> getByNames(String name, String next);

    List<ExtendableCategory> getListTopExtendableCategories();

    void delete(ExtendableCategory extendableCategory);

    ExtendableCategory getByName(String name);

}
