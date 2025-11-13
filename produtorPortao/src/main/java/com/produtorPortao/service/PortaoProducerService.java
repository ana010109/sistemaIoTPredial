package com.produtorPortao.service;

import com.produtorPortao.config.RabbitMQConfig;
import com.produtorPortao.dto.PortaoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PortaoProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${config.rabbitmq.routing-key}")
    private String routingKey;

    public PortaoProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarComando(PortaoDTO comandoDTO) {
        
        Object payload = comandoDTO;

        System.out.println("-> [PRODUCER PORTAO] Enviando DTO (Ação: " + comandoDTO.getAcao() + 
                           " | ID: " + comandoDTO.getIdDispositivo() +
                           " | Área: " + comandoDTO.getArea() +
                           ") | Routing Key: " + routingKey);
        
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey, payload);
    }
}