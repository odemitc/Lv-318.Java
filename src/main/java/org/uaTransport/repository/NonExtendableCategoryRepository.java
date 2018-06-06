package org.uaTransport.repository;

import org.uaTransport.entity.NonExtendableCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NonExtendableCategoryRepository extends JpaRepository<NonExtendableCategory, Integer> {

    List<NonExtendableCategory> findByNextLevelCategoryId(int id);

    List<NonExtendableCategory> findByNextLevelCategoryNameAndNextLevelCategoryNextLevelCategoryName(String top, String next);

}
