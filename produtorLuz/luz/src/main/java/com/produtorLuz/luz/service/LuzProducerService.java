
package com.produtorLuz.luz.service;

import com.produtorLuz.luz.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LuzProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${luz.rabbitmq.routing-key}")
    private String routingKey;

    public LuzProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarComando(String comando) {
        
        String payload = String.format("{\"equipamento\": \"Luz\", \"comando\": \"%s\", \"timestamp\": %d}", 
                                       comando, 
                                       System.currentTimeMillis());

        System.out.println("-> [PRODUCER LUZ] Enviando comando: " + payload + 
                           " | Exchange: " + RabbitMQConfig.EXCHANGE_NAME + 
                           " | Routing Key: " + routingKey);
                           
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey, payload);
    }
}