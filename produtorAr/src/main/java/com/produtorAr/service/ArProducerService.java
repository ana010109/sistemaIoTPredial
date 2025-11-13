package com.produtorAr.service;

import com.produtorAr.config.RabbitMQConfig;
import com.produtorAr.dto.ArDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ArProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${config.rabbitmq.routing-key}")
    private String routingKey;

    public ArProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarComando(ArDTO comandoDTO) {
        
        Object payload = comandoDTO;

        System.out.println("-> [PRODUCER AR] Enviando DTO (Ação: " + comandoDTO.getAcao() + 
                           " | Temp: " + comandoDTO.getTemperatura() +
                           ") | Routing Key: " + routingKey);
        
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey, payload);
    }
}