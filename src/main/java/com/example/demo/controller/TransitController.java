package com.example.demo.controller;

import com.example.demo.entity.Transit;
import com.example.demo.service.TransitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TransitController {

    private TransitService transitService;

    public TransitController(TransitService transitService) {
        this.transitService = transitService;
    }

    @GetMapping("/transit/{number}")
    @ResponseBody
    public Transit getTransit(@PathVariable int number) {
        return transitService.getById(number).get();
    }
}
