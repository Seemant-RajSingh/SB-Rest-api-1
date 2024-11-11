package com.srs.REST.API.config;

import com.srs.REST.API.DB;
import com.srs.REST.API.DevDB;
import com.srs.REST.API.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //means expect many Beans in this class
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean() {
        return new DevDB();
    }
    // return type DB, getProd/DevBean and other functions are called at app start for all beans
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean() {
        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}

// config + beans => SB controls creating singleton objects(can edit to multiples)
// ConditionalOnProperty - to decide which bean to load based on condition (env var here)
// can change env vars from app.props or with IDE (overrides app.prop)
