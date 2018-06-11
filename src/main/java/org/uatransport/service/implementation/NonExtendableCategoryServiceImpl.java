package org.uatransport.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uatransport.entity.NonExtendableCategory;
import org.uatransport.entity.dto.NonExtendableCategoryDto;
import org.uatransport.exception.ResourceNotFoundException;
import org.uatransport.repository.NonExtendableCategoryRepository;
import org.uatransport.service.ExtendebleCategoryService;
import org.uatransport.service.FeedbackCriteriaService;
import org.uatransport.service.NonExtendableCategoryService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NonExtendableCategoryServiceImpl implements NonExtendableCategoryService {

    private final NonExtendableCategoryRepository nonExtendableCategoryRepository;
    private final ExtendebleCategoryService extendableCategoryService;
    private final FeedbackCriteriaService feedbackCriteriaService;

    @Override
    @Transactional
    public NonExtendableCategory addNonExtendableCategory(NonExtendableCategory nonExtendableCategory) {
        if (nonExtendableCategory.getNextLevelCategory() == null) {
            throw new IllegalArgumentException("NonExtendableCategory must contain next level Category");
        }
        return nonExtendableCategoryRepository.save(nonExtendableCategory);
    }

    @Override
    public NonExtendableCategory addNonExtendableCategory(NonExtendableCategoryDto nonExtendableCategory) {
        NonExtendableCategory categoryToSave = new NonExtendableCategory();

        categoryToSave.setName(nonExtendableCategory.getName());
        categoryToSave.setNextLevelCategory(extendableCategoryService.getById(nonExtendableCategory.getNextLevelCategory()));

        if (nonExtendableCategory.getFeedbackCriterias() != null) {
            nonExtendableCategory.getFeedbackCriterias()
                    .forEach(id -> categoryToSave
                            .getFeedbackCriterias()
                            .add(feedbackCriteriaService.getById(id)));
        }

        return addNonExtendableCategory(categoryToSave);
    }

    @Override
    @Transactional
    public void delete(int id) {
        nonExtendableCategoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public NonExtendableCategory update(NonExtendableCategory nonExtendableCategory) {
        if (nonExtendableCategoryRepository.existsById(nonExtendableCategory.getId())) {
            return nonExtendableCategoryRepository.save(nonExtendableCategory);
        } else {
            throw new ResourceNotFoundException(String.format("Category with id '%s' not found", nonExtendableCategory.getId()));
        }
    }

    @Override
    public List<NonExtendableCategory> getByNextLevelCategory(int id) {
        return nonExtendableCategoryRepository.findByNextLevelCategoryId(id);
    }

    @Override
    public NonExtendableCategory getById(Integer id) {
        return nonExtendableCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Category with id '%s' not found", id)));
    }

    @Override
    public List<NonExtendableCategory> getByNames(String name, String next) {
        return nonExtendableCategoryRepository.findByNextLevelCategoryNameAndNextLevelCategoryNextLevelCategoryName(name, next);
    }
}
