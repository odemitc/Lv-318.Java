package org.uaTransport.service;

import org.uaTransport.entity.NonExtendableCategory;
import org.uaTransport.entity.dto.NonExtendableCategoryDto;

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
