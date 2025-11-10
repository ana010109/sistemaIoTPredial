
package com.produtorLuz.luz.service;

import com.produtorLuz.luz.config.RabbitMQConfig;
import com.produtorLuz.luz.dto.LuzDTO;
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

public void enviarComando(LuzDTO comandoDTO) {
      
        Object payload = comandoDTO; 

        System.out.println("-> [PRODUCER LUZ] Enviando DTO (Ação: " + comandoDTO.getAcao() + 
                           ") | Routing Key: " + routingKey +
                           " | Timestamp: " + comandoDTO.getTimestamp()); // Apenas mudamos a visualização
        
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey, payload);
    }
}