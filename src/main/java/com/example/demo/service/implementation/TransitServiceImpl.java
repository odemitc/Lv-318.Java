package com.example.demo.service.implementation;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.entity.Stop;
import com.example.demo.entity.Transit;
import com.example.demo.repository.TransitRepository;
import com.example.demo.service.TransitService;
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
public class TransitServiceImpl implements TransitService {

    private final TransitRepository transitRepository;

    @Override
    @Transactional
    public Transit addTransit(Transit transit) {
        if (transit == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return transitRepository.save(transit);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        try {
            transitRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Transit with id '%s' not found", id));
        }
    }

    @Override
    @Transactional
    public void delete(Transit transit) {
        if (transit == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        try {
            transitRepository.delete(transit);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Transit with id '%s' not found", transit.getId()));
        }
    }

    @Override
    @Transactional
    public Transit update(Transit transit) {
        if (transit == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return transitRepository.findById(transit.getId())
            .map(transit1 -> transitRepository.save(transit))
            .orElseThrow(() -> new ResourceNotFoundException(String
                .format("Transit with id '%s' not found", transit.getId())));
    }

    @Override
    @Transactional(readOnly = true)
    public Transit getById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return transitRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String
                .format("Transit with id '%s' not found", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public Transit getByName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        return transitRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transit> getAllByCategoryName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Category name should not be empty");
        }
        List<Transit> transits = transitRepository.findTransitsByCategoryName(name);
        if (transits.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Category with name '%s' not found", name));
        } else {
            return transits;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transit> getAllByCategoryId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        List<Transit> transits = transitRepository.findTransitsByCategoryId(id);
        if (transits.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Category with id '%s' not found", id));
        } else {
            return transits;
        }
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
