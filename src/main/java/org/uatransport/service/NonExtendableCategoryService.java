package org.uatransport.service;

import org.uatransport.entity.NonExtendableCategory;
import org.uatransport.entity.dto.NonExtendableCategoryDto;

import java.util.List;

public interface NonExtendableCategoryService {

    NonExtendableCategory addNonExtendableCategory(NonExtendableCategory nonExtendableCategory);

    NonExtendableCategory addNonExtendableCategory(NonExtendableCategoryDto nonExtendableCategory);

    void delete(int id);

    NonExtendableCategory update(NonExtendableCategory nonExtendableCategory);

    List<NonExtendableCategory> getByNextLevelCategory(int id);

    NonExtendableCategory getById(Integer id);

    List<NonExtendableCategory> getByNames(String name, String next);
}
