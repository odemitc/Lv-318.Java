package com.example.demo.service.implementation;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.ExtendableCategory;
import com.example.demo.repository.ExtendableCategoryRepository;
import com.example.demo.service.ExtendebleCategoryService;
import com.google.common.base.Strings;
import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExtendableCategoryServiceImpl implements ExtendebleCategoryService {
    private final ExtendableCategoryRepository extendableCategoryRepository;

    @Override
    @Transactional
    public ExtendableCategory save(ExtendableCategory extendableCategory) {
        if (extendableCategory == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return extendableCategoryRepository.save(extendableCategory);
    }

    @Override
    @Transactional
    public void delete(ExtendableCategory extendableCategory) {
        if (extendableCategory == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        try {
            extendableCategoryRepository.delete(extendableCategory);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Category with id '%s' not found", extendableCategory.getId()));
        }
    }

    @Override
    public ExtendableCategory update(ExtendableCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return extendableCategoryRepository.findById(category.getId())
                .map(category1 -> extendableCategoryRepository.save(category))
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Category with id '%s' not found", category.getId())));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        try {
            extendableCategoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Category with id '%s' not found", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ExtendableCategory getByName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        return extendableCategoryRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> getListTopExtendableCategories() {
        return extendableCategoryRepository.findAllByNextLevelCategoryIsNull();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> getListExtendableCategories() {
        return Streams.stream(extendableCategoryRepository.findAll()).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> getByNextLevelCategoryId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        List<ExtendableCategory> categoryList = extendableCategoryRepository.findByNextLevelCategoryId(id);
        if(categoryList.isEmpty()){
            throw new ResourceNotFoundException(String.format("Category with id '%s' not found", id));
        }
        return categoryList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> getByNextLevelCategory(ExtendableCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        List<ExtendableCategory> categoryList = extendableCategoryRepository.findByNextLevelCategory(category);
        if(categoryList.isEmpty()){
            throw new ResourceNotFoundException("Such category  not found");
        }
        return categoryList;
    }

    @Override
    public ExtendableCategory getByNameAndNextLevelCategory(String name, ExtendableCategory nextLevel) {
        if (name == null || nextLevel == null ) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        ExtendableCategory extendableCategory = extendableCategoryRepository.findByNameAndNextLevelCategory(name, nextLevel);
        if(extendableCategory == null){
            throw new ResourceNotFoundException("Such category  not found");
        }
        return extendableCategory;
    }
}
