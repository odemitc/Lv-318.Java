package com.uatransport.controllers;


import com.uatransport.model.Transport;
import com.uatransport.repositories.TransportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TransportController {

    TransportRepository transportRepository;

    public TransportController(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @RequestMapping("/")
    @ResponseBody
    public Iterable<Transport> getTransport() {
        return transportRepository.findAll();
    }
}
