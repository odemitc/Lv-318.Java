package org.uatransport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class UaTransportApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context =
            SpringApplication.run(UaTransportApplication.class, args);

    }
}
