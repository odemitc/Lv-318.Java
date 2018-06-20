package org.uatransport;

import jdk.management.resource.internal.inst.StaticInstrumentation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
