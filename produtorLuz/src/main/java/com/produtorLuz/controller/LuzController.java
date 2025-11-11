package com.produtorLuz.luz.controller;

import com.produtorLuz.luz.service.LuzProducerService;
import com.produtorLuz.luz.dto.LuzDTO; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/luz")
public class LuzController {

    private final LuzProducerService producerService;

    public LuzController(LuzProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<String> recebeComandoLuz(@RequestBody LuzDTO comandoDTO) { 
        
        System.out.println("-> [CONTROLLER LUZ] Requisição HTTP POST recebida para Área: " + comandoDTO.getArea());
    
        producerService.enviarComando(comandoDTO); 
        
        return ResponseEntity.accepted().body("Comando de luz aceito e enviado para o Message Broker.");
    }
}