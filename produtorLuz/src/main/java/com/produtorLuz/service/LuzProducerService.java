package com.produtorLuz.service;

import com.produtorLuz.config.RabbitMQConfig;
import com.produtorLuz.dto.LuzDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LuzProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${config.rabbitmq.routing-key}")
    private String routingKey;

    public LuzProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

public void enviarComando(LuzDTO comandoDTO) {
      
        Object payload = comandoDTO; 

        System.out.println("-> [PRODUCER LUZ] Enviando DTO (Ação: " + comandoDTO.getAcao() + 
                           ") | Routing Key: " + routingKey +
                           " | Timestamp: " + comandoDTO.getTimestamp()); // Apenas mudamos a visualização
        
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey, payload);
    }
}