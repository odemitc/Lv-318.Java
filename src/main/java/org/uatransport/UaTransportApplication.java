package org.uatransport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uatransport.controller.UserController;
import org.uatransport.entity.dto.UserDTO;
import org.uatransport.repository.UserRepository;

import javax.jnlp.UnavailableServiceException;

@SpringBootApplication
@Slf4j
public class UaTransportApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaTransportApplication.class, args);



    }
}
