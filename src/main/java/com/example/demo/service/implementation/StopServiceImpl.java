package com.example.demo.service.implementation;

import com.example.demo.entity.Stop;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StopRepository;
import com.example.demo.service.StopService;
import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StopServiceImpl implements StopService {


    private final StopRepository stopRepository;

    @Override
    @Transactional
    public Stop addStop(Stop stop) {
        if (stop == null) {
            throw new IllegalArgumentException("Parameter should not be empty");
        }
        return stopRepository.save(stop);
    }

    @Override
    @Transactional(readOnly = true)
    public Stop getById(Integer id) {
        return stopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Feedback with id '%s' not found", id)));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        try {
            stopRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Transit with id '%s' not found", id));
        }
    }


    @Override
    @Transactional
    public Stop update(Stop stop) {
        if (stop == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return stopRepository.findById(stop.getId())
                .map(transit1 -> stopRepository.save(stop))
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Transit with id '%s' not found", stop.getId())));
    }

    @Override
    @Transactional
    public List<Stop> getStopsByStreet(String street) {
        if (Strings.isNullOrEmpty(street)) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return stopRepository.findStopsByStreet(street);
    }

}
