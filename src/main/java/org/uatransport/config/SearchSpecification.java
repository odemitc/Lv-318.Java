package org.uatransport.config;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.uatransport.entity.ExtendableCategory;
import org.uatransport.service.CategoryService;

@RequiredArgsConstructor
public class SearchSpecification implements Specification<ExtendableCategory> {
  private final SearchCategoryParam searchCategoryParam;
  private final CategoryService categoryService;

  @Override
  public Predicate toPredicate(
      Root<ExtendableCategory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    Predicate predicate = criteriaBuilder.disjunction();

    if (searchCategoryParam.getName() != null
        && searchCategoryParam.getNextLevelCategoryName() != null) {
      predicate
          .getExpressions()
          .add(
              root.in(
                  categoryService.getByNames(
                      searchCategoryParam.getName(),
                      searchCategoryParam.getNextLevelCategoryName())));

    } else {
      if (searchCategoryParam.getName() != null) {
        predicate
            .getExpressions()
            .add(criteriaBuilder.equal(root.get("name"), searchCategoryParam.getName()));
      } else if (searchCategoryParam.getNextLevelCategoryName() != null) {
        predicate
            .getExpressions()
            .add(
                criteriaBuilder.equal(
                    root.get("nextLevelCategory"),
                    categoryService.getByName(searchCategoryParam.getNextLevelCategoryName())));
      }
    }

    if (searchCategoryParam.getId() != null) {
      predicate
          .getExpressions()
          .add(criteriaBuilder.equal(root.get("id"), searchCategoryParam.getId()));
    }

    if (searchCategoryParam.getNextLevelCategoryName() == null
        && searchCategoryParam.getNextLevelCategoryName() == null
        && searchCategoryParam.getId() == null) {
      predicate.getExpressions().add(root.in(categoryService.getListTopExtendableCategories()));
    }
    return predicate;
  }
}
