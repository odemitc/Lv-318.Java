package com.example.demo.service;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.entity.Transit;
import com.example.demo.repository.TransitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransitServiceImpl implements TransitService {

    private TransitRepository transitRepository;

    public TransitServiceImpl(TransitRepository transitRepository) {
        this.transitRepository = transitRepository;
    }

    @Override
    public Transit addTransit(Transit transit) {
        return transitRepository.saveAndFlush(transit);
    }

    @Override
    public void delete(int id) {
        transitRepository.deleteById(id);
    }

    @Override
    public void delete(Transit transit) {
        transitRepository.delete(transit);
    }

    @Override
    public Transit update(Transit transit) {
        return transitRepository.saveAndFlush(transit);
    }

    @Override
    public Transit getById(int id) {
        return transitRepository.findById(id).get();
    }

    @Override
    public Transit getByName(String name) {
        return transitRepository.findByName(name);
    }

    @Override
    public List<Transit> getAllByCategory(NonExtendableCategory nonExtendableCategory) {
        return transitRepository.findTransitsByCategory(nonExtendableCategory);
    }


    @Override
    public List<Transit> getAllByCategoryId(int id) {
        return transitRepository.findTransitsByCategoryId(id);
    }

    @Override
    public List<Transit> getAll() {
        return transitRepository.findAll();
    }
}
