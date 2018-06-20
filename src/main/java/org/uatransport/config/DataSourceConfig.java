package org.uatransport.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:data-access.properties")
public class DataSourceConfig {

    private final Environment env;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().url(env.getProperty("spring.datasource.url"))
            .username(env.getProperty("spring.datasource.username")).password(env.getProperty("spring.datasource.password"))
            .build();
    }
}
