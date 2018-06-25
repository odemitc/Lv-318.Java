package org.uatransport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.uatransport.controller.UserController;
import org.uatransport.entity.dto.UserDTO;
import org.uatransport.repository.UserRepository;

import javax.jnlp.UnavailableServiceException;
import javax.xml.bind.SchemaOutputResolver;

@SpringBootApplication
@Slf4j
public class UaTransportApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UaTransportApplication.class, args);

       //UserDTO userDTO=new UserDTO("test","test","test","test");
      //  System.out.println(context.getBean(UserController.class).signUp(userDTO));

    }
}
