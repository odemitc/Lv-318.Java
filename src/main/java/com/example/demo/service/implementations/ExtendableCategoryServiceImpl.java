package com.example.demo.service.implementations;

import com.example.demo.entity.ExtendableCategory;
import com.example.demo.repository.ExtendableCategoryRepository;
import com.example.demo.service.interfaces.ExtendebleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExtendebleCategoryServiceImpl implements ExtendebleCategoryService {

    @Autowired
    private ExtendableCategoryRepository extendableCategoryRepository;

    @Override
    public ExtendableCategory save(ExtendableCategory extendableCategory) {
        extendableCategoryRepository.save(extendableCategory);
        return extendableCategory;
    }

    @Override
    public void delete(ExtendableCategory extendableCategory) {
        extendableCategoryRepository.delete(extendableCategory);
    }

    @Override
    public Optional<ExtendableCategory> findByName(String name) {
        return extendableCategoryRepository.findByName(name);
    }

    @Override
    public List<ExtendableCategory> listExtendableCategories() {
        List<ExtendableCategory> extendableCategoryList = new ArrayList<>();
        extendableCategoryRepository.findAll()
                .forEach(extendableCategory -> extendableCategoryList.add(extendableCategory));
        return extendableCategoryList;
    }

    @Override
    public List<ExtendableCategory> findByNextLevelCategoryId(Integer id) {
        return extendableCategoryRepository.findByNextLevelCategoryId(id);
    }

    @Override
    public List<ExtendableCategory> findByNextLevelCategory(ExtendableCategory category) {
        return 
    }
}
