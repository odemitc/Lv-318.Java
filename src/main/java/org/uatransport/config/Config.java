package org.uatransport.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // @Bean
    // public FilterRegistrationBean filterRegistrationBean(){
    // FilterRegistrationBean filter = new FilterRegistrationBean();
    // filter.setFilter(new CorsFilter());
    // filter.setUrlPatterns(Collections.singleton("/**"));
    // filter.setName("Cors filter");
    // return filter;
    // }
}
