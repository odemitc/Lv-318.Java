package com.example.demo.service.implementation;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.repository.NonExtendableCategoryRepository;
import com.example.demo.service.NonExtendableCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NonExtendableCategoryServiceImpl implements NonExtendableCategoryService {

    private final NonExtendableCategoryRepository nonExtendableCategoryRepository;

    @Override
    public NonExtendableCategory addNonExtendableCategory(NonExtendableCategory nonExtendableCategory) {
        if (nonExtendableCategory.getNextLevelCategory() == null) {
            throw new IllegalArgumentException("NonExtendableCategory must contain next level Category");
        }
        return nonExtendableCategoryRepository.saveAndFlush(nonExtendableCategory);
    }

    @Override
    public void delete(int id) {
        nonExtendableCategoryRepository.deleteById(id);
    }

    @Override
    public void delete(NonExtendableCategory nonExtendableCategory) {
        nonExtendableCategoryRepository.delete(nonExtendableCategory);
    }

    @Override
    public NonExtendableCategory update(NonExtendableCategory nonExtendableCategory) {
        return nonExtendableCategoryRepository.saveAndFlush(nonExtendableCategory);
    }

    @Override
    public NonExtendableCategory getByName(String name) {
        return nonExtendableCategoryRepository.findByName(name);
    }

    @Override
    public NonExtendableCategory getByNextLevelCategory(int id) {
        return nonExtendableCategoryRepository.findByNextLevelCategoryId(id);
    }

    @Override
    public NonExtendableCategory getById(int id){
        return nonExtendableCategoryRepository.findById(id);
    }
    @Override
    public List<NonExtendableCategory> getAll() {
        return nonExtendableCategoryRepository.findAll();
    }
}
