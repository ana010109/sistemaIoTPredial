package com.produtorAr.controller;

import com.produtorAr.service.ArProducerService;
import com.produtorAr.dto.ArDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ar")
public class ArController {

    private final ArProducerService producerService;

    public ArController(ArProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<String> recebeComandoAr(@RequestBody ArDTO comandoDTO) { 
        
        // ** VALIDAÇÃO DE TEMPERATURA **
        if ("SETAR".equalsIgnoreCase(comandoDTO.getAcao()) && (comandoDTO.getTemperatura() == null || comandoDTO.getTemperatura() < 15 || comandoDTO.getTemperatura() > 27)) {
            return ResponseEntity.badRequest().body("A temperatura deve ser setada entre 15 e 27 graus para a ação 'SETAR'.");
        }
        
        System.out.println("-> [CONTROLLER AR] Requisição HTTP POST recebida para Área: " + comandoDTO.getArea());
        
        producerService.enviarComando(comandoDTO); 
        
        return ResponseEntity.accepted().body("Comando de ar-condicionado aceito e enviado para o Message Broker.");
    }
}