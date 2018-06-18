package org.uatransport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UaTransportApplication {
  private static Logger logger = LoggerFactory.getLogger(UaTransportApplication.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        SpringApplication.run(UaTransportApplication.class, args);
    logger.debug("--Application Started--");
  }
}
