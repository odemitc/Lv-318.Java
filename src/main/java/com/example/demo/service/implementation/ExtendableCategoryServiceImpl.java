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
    public Optional<ExtendableCategory> findByName(String name) {

        return extendableCategoryRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> listExtendableCategories() {
        return StreamSupport.stream(extendableCategoryRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> findByNextLevelCategoryId(Integer id) {
        return extendableCategoryRepository.findByNextLevelCategoryId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExtendableCategory> findByNextLevelCategory(ExtendableCategory category) {
        return extendableCategoryRepository.findByNextLevelCategory(category);
    }
}
