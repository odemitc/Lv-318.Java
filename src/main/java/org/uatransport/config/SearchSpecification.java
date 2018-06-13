package org.uatransport.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.uatransport.entity.ExtendableCategory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class SearchSpecification implements Specification<ExtendableCategory> {
    private final SearchCategoryParam searchCategoryParam;

    @Override
    public Predicate toPredicate(Root<ExtendableCategory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.disjunction();

        if (searchCategoryParam.getName() != null && searchCategoryParam.getNextLevelCategoryName() != null) {
            predicate.getExpressions().add(
                criteriaBuilder.and(criteriaBuilder.equal(root.get("name"), searchCategoryParam.getName()),
                        criteriaBuilder.equal(root.get("nextLevelCategoryName"),searchCategoryParam.getNextLevelCategoryName()))
            );
        }

        if (searchCategoryParam.getId() != null) {
            predicate.getExpressions()
                    .add(criteriaBuilder.equal(root.get("id"), searchCategoryParam.getId()));
        }

        return predicate;
    }
}


