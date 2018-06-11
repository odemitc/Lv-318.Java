package org.uatransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.uatransport.entity.NonExtendableCategory;

import java.util.List;


public interface NonExtendableCategoryRepository extends CrudRepository<NonExtendableCategory, Integer> {

    List<NonExtendableCategory> findByNextLevelCategoryId(int id);

    List<NonExtendableCategory> findByNextLevelCategoryNameAndNextLevelCategoryNextLevelCategoryName(String top, String next);

}
