package org.uatransport.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.uatransport.config.modelmapperconfig.TransitMap;
import org.uatransport.entity.Transit;
import org.uatransport.entity.dto.TransitDTO;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Transit.class, TransitDTO.class).setConverter(new TransitMap());
        return modelMapper;
    }
}
