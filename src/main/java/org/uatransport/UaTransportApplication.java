package org.uatransport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.uatransport.config.ConfigurationUtils.getPropertyValue;

@SpringBootApplication
public class UaTransportApplication {
    private static Logger logger = LoggerFactory.getLogger(UaTransportApplication.class);


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UaTransportApplication.class, args);
        logger.debug("--Application Started--");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter(){
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/*").allowedOrigins(getPropertyValue("url"));
            }
        };
    }
}
