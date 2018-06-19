package org.uatransport.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.uatransport.entity.ExtendableCategory;
import org.uatransport.entity.NonExtendableCategory;

public interface CategoryRepository
    extends CrudRepository<ExtendableCategory, Integer>,
        JpaSpecificationExecutor<CategoryRepository> {

  ExtendableCategory findByName(String name);

  List<ExtendableCategory> findByNextLevelCategoryId(Integer id);

  List<ExtendableCategory> findByNextLevelCategory(ExtendableCategory extendableCategory);

  List<ExtendableCategory> findAllByNextLevelCategoryIsNull();

  ExtendableCategory findByNameAndNextLevelCategory(
      String name, ExtendableCategory nextLevelCategory);

  List<NonExtendableCategory> findByNextLevelCategoryNameAndNextLevelCategoryNextLevelCategoryName(
      String top, String next);
}
