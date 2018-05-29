package com.example.demo.controller;

import com.example.demo.entity.DTO.TransitDTO;
import com.example.demo.entity.Transit;
import com.example.demo.service.TransitService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TransitController {

    private TransitService transitService;
    private ModelMapper modelMapper;

    public TransitController(TransitService transitService) {
        this.transitService = transitService;
        modelMapper = new ModelMapper();
    }

    @GetMapping("/transit/simple/{number}")
    public ResponseEntity<TransitDTO> getSimpleTransit(@PathVariable int number) {
        TransitDTO transitDTO = modelMapper.map(transitService.getById(number).get(), TransitDTO.class);
        return new ResponseEntity<>(transitDTO, HttpStatus.OK);
    }

    @GetMapping("transit/{number}")
    public ResponseEntity<Transit> getTransit(@PathVariable int number) {
        return new ResponseEntity<>(transitService.getById(number).get(), HttpStatus.OK);
    }

    @GetMapping("/transit")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<Transit>> getAllTransits() {
        return new ResponseEntity<>(transitService.getAll(), HttpStatus.OK);
    }
}
