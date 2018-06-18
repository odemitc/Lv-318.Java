package org.uatransport.service.implementation;

import com.google.common.base.Strings;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uatransport.entity.ExtendableCategory;
import org.uatransport.entity.NonExtendableCategory;
import org.uatransport.entity.dto.NonExtendableCategoryDto;
import org.uatransport.exception.ResourceNotFoundException;
import org.uatransport.repository.CategoryRepository;
import org.uatransport.service.CategoryService;
import org.uatransport.service.FeedbackCriteriaService;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;
  private final FeedbackCriteriaService feedbackCriteriaService;

  @Override
  @Transactional
  public ExtendableCategory save(ExtendableCategory category) {
    if (category == null) {
      throw new IllegalArgumentException("Parameter should not be null");
    }
    return categoryRepository.save(category);
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      throw new IllegalArgumentException("Parameter should not be null");
    }
    try {
      categoryRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(String.format("Category with id '%s' not found", id));
    }
  }

  @Override
  public ExtendableCategory update(ExtendableCategory categoryToUpdate) {
    if (categoryRepository.existsById(categoryToUpdate.getId())) {
      return categoryRepository.save(categoryToUpdate);
    } else {
      throw new ResourceNotFoundException(
          String.format("Category with id '%s' not found", categoryToUpdate.getId()));
    }
  }

  @Override
  public ExtendableCategory getById(Integer id) {
    return categoryRepository
        .findById(id)
        .orElseThrow(
            () ->
                new ResourceNotFoundException(
                    String.format("Category with id '%s' not found", id)));
  }

  @Override
  public List<ExtendableCategory> getByNextLevelCategoryId(Integer id) {
    if (id == null) {
      throw new IllegalArgumentException("Parameter should not be null");
    }
    List<ExtendableCategory> categoryList = categoryRepository.findByNextLevelCategoryId(id);
    if (categoryList.isEmpty()) {
      throw new ResourceNotFoundException(String.format("Category with id '%s' not found", id));
    }
    return categoryList;
  }

  @Override
  public NonExtendableCategory addNonExtendableCategory(
      NonExtendableCategoryDto nonExtendableCategoryDto) {
    NonExtendableCategory categoryToSave = new NonExtendableCategory();

    categoryToSave.setName(nonExtendableCategoryDto.getName());

    categoryToSave.setNextLevelCategory(
        categoryRepository
            .findById(nonExtendableCategoryDto.getNextLevelCategory())
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        String.format(
                            "Category with id '%s' not found",
                            nonExtendableCategoryDto.getNextLevelCategory()))));

    if (nonExtendableCategoryDto.getFeedbackCriterias() != null) {
      nonExtendableCategoryDto
          .getFeedbackCriterias()
          .forEach(
              id -> categoryToSave.getFeedbackCriterias().add(feedbackCriteriaService.getById(id)));
    }

    return (NonExtendableCategory) save(categoryToSave);
  }

  @Override
  public List<NonExtendableCategory> getByNames(String name, String next) {
    return categoryRepository.findByNextLevelCategoryNameAndNextLevelCategoryNextLevelCategoryName(
        name, next);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ExtendableCategory> getListTopExtendableCategories() {
    return categoryRepository.findAllByNextLevelCategoryIsNull();
  }

  @Override
  @Transactional
  public void delete(ExtendableCategory extendableCategory) {
    if (extendableCategory == null) {
      throw new IllegalArgumentException("Parameter should not be null");
    }
    try {
      categoryRepository.delete(extendableCategory);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(
          String.format("Category with id '%s' not found", extendableCategory.getId()));
    }
  }

  @Override
  @Transactional(readOnly = true)
  public ExtendableCategory getByName(String name) {
    if (Strings.isNullOrEmpty(name)) {
      throw new IllegalArgumentException("Name should not be empty");
    }
    return categoryRepository.findByName(name);
  }

  public List<ExtendableCategory> getAll(Specification specification) {
    return categoryRepository.findAll(specification);
  }

  public ExtendableCategory getByNameAndNextLevelCategory(
      String name, ExtendableCategory nextLevel) {
    if (name == null || nextLevel == null) {
      throw new IllegalArgumentException("Parameter should not be null");
    }
    ExtendableCategory extendableCategory =
        categoryRepository.findByNameAndNextLevelCategory(name, nextLevel);
    if (extendableCategory == null) {
      throw new ResourceNotFoundException("Such category  not found");
    }
    return extendableCategory;
  }
}
