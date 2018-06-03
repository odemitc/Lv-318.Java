package com.example.demo.service;

import com.example.demo.entity.Rate;
import com.example.demo.entity.Stop;

import java.util.Optional;

public interface RateService {

    Rate addRate(Rate rate);

    Rate update(Rate rate);

    Rate getById(Integer id);
}
