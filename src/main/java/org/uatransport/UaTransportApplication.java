package org.uatransport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.uatransport.service.ewayutil.EwayRoutesListSaver;
import org.uatransport.service.ewayutil.EwayStopListSaver;
import org.uatransport.service.ewayutil.ewayentity.EwayResponseObject;
import org.uatransport.service.ewayutil.ewayentity.EwayRoute;
import org.uatransport.service.ewayutil.ewayentity.EwayRouteList;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class UaTransportApplication {
    private static Logger logger = LoggerFactory.getLogger(UaTransportApplication.class);


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UaTransportApplication.class, args);
        logger.debug("--Application Started--");

        EwayRoutesListSaver ewayRoutesListSaver = (EwayRoutesListSaver) context.getBean(EwayRoutesListSaver.class);
            ewayRoutesListSaver.convertAndSaveEwayRoutes();

        EwayStopListSaver stopListSaver = (EwayStopListSaver) context.getBean(EwayStopListSaver.class);
//        stopListSaver.convertAndSaveStops("21");
    }
}
