package com.produtorLuz.luz.controller;

import com.produtorLuz.luz.service.LuzProducerService;
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

    /**
     * Recebe um comando (payload) para ser enviado ao Message Broker.
     * * @param comando O corpo da requisição, que contém o comando de luz (ex: "ON", "OFF").
     * @return ResponseEntity 202 Accepted, indicando que a mensagem foi enfileirada.
     */
    
    @PostMapping
    public ResponseEntity<String> recebeComandoLuz(@RequestBody String comando) {
        
        System.out.println("-> [CONTROLLER LUZ] Requisição HTTP POST recebida com comando: " + comando);
        producerService.enviarComando(comando);
        return ResponseEntity.accepted().body("Comando de luz aceito e enviado para o Message Broker.");
    }
}