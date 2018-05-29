package com.example.demo.service.implementation;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.entity.Stop;
import com.example.demo.entity.Transit;
import com.example.demo.repository.TransitRepository;
import com.example.demo.service.TransitService;
import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransitServiceImpl implements TransitService {

    private final TransitRepository transitRepository;

    @Override
    @Transactional
    public Transit addTransit(Transit transit) {
        return transitRepository.save(transit);
    }

    @Override
    @Transactional
    public void delete(int id) {
        transitRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Transit transit) {
        transitRepository.delete(transit);
    }

    @Override
    @Transactional
    public Transit update(Transit transit) {
        return transitRepository.save(transit);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transit> getById(int id) {
        return transitRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Transit getByName(String name) {
        return transitRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transit> getAllByCategory(NonExtendableCategory nonExtendableCategory) {
        return transitRepository.findTransitsByCategory(nonExtendableCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transit> getAllByCategoryId(int id) {
        return transitRepository.findTransitsByCategoryId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transit> getAll() {
        return Streams.stream(transitRepository.findAll()).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transit> getTransitsByStopsIn(Stop [] stops) {
        return transitRepository.findTransitsByStopsIn(stops);
    }
}
