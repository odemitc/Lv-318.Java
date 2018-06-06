package org.uaTransport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uaTransport.entity.NonExtendableCategory;

import java.util.List;


public interface NonExtendableCategoryRepository extends JpaRepository<NonExtendableCategory, Integer> {

    List<NonExtendableCategory> findByNextLevelCategoryId(int id);

    List<NonExtendableCategory> findByNextLevelCategoryNameAndNextLevelCategoryNextLevelCategoryName(String top, String next);

}
