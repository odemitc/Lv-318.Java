package com.example.demo.service.implementation;

import com.example.demo.entity.Stop;
import com.example.demo.repository.StopRepository;
import com.example.demo.service.StopService;
import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Optional<Stop> getById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return stopRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
         stopRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Stop update(Stop stop) {
        if (stop == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return stopRepository.save(stop);
    }
    @Override
    @Transactional
    public List<Stop> getStopsByStreet(String street) {
        if (street == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return stopRepository.findStopsByStreet(street);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Stop> getAll() {
        return Streams.stream(stopRepository.findAll()).collect(Collectors.toList());
    }

    @Override
    public Stop getStopByBuilding(String building) {
        return stopRepository.findStopByBuilding(building);
    }
}
