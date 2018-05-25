package com.uatransport.bootstrap;

import com.uatransport.model.Transport;
import com.uatransport.model.Vehicle;
import com.uatransport.repositories.TransportRepository;
import com.uatransport.repositories.VehicleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private TransportRepository transportRepository;
    private VehicleRepository vehicleRepository;

    public DevBootstrap(TransportRepository transportRepository, VehicleRepository vehicleRepository) {
        this.transportRepository = transportRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {
        Transport a1 = new Transport("a1");
        Vehicle v1 = new Vehicle("v1");
        Vehicle v2 = new Vehicle("v2");
        Vehicle v3 = new Vehicle("v3");
        a1.getVehicles().add(v1);
        a1.getVehicles().add(v2);
        a1.getVehicles().add(v3);
        vehicleRepository.save(v1);
        vehicleRepository.save(v2);
        vehicleRepository.save(v3);
        Transport a2 = new Transport("a2");
        transportRepository.save(a1);
        transportRepository.save(a2);

    }
}
