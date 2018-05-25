package com.uatransport.bootstrap;

import com.uatransport.model.Transport;
import com.uatransport.repositories.TransportRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private TransportRepository transportRepository;

    public DevBootstrap(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {
        Transport a1 = new Transport("a1");
        transportRepository.save(a1);
    }
}
