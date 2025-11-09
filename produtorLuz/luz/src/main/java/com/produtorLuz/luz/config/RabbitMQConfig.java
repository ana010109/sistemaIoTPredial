package com.produtorLuz.luz.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "exchange_principal";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME); 
    }
}