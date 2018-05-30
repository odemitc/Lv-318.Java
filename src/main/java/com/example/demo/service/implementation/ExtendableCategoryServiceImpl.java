package com.example.demo.service.implementation;

import com.example.demo.entity.ExtendableCategory;
import com.example.demo.repository.ExtendableCategoryRepository;
import com.example.demo.service.ExtendebleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ExtendableCategoryServiceImpl implements ExtendebleCategoryService {
    private final ExtendableCategoryRepository extendableCategoryRepository;

    @Override
    @Transactional
    public ExtendableCategory save(ExtendableCategory extendableCategory) {
        extendableCategoryRepository.save(extendableCategory);
        return extendableCategory;
    }

    @Override
    @Transactional
    public void delete(ExtendableCategory extendableCategory) {
        extendableCategoryRepository.delete(extendableCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public ExtendableCategory getByName(String name) {

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
        return StreamSupport.stream(extendableCategoryRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> getByNextLevelCategoryId(Integer id) {
        return extendableCategoryRepository.findByNextLevelCategoryId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> getByNextLevelCategory(ExtendableCategory category) {
        return extendableCategoryRepository.findByNextLevelCategory(category);
    }

    @Override
    public ExtendableCategory getByNameAndNextLevelCategory(String name, ExtendableCategory nextLevel) {
        return extendableCategoryRepository.findByNameAndNextLevelCategory(name, nextLevel);
    }
}
