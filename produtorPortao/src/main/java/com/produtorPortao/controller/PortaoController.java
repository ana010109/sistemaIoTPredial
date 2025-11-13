package com.produtorPortao.controller;

import com.produtorPortao.dto.PortaoDTO;
import com.produtorPortao.service.PortaoProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portao")
public class PortaoController {

    private final PortaoProducerService portaoProducerService;

    public PortaoController(PortaoProducerService portaoProducerService) {
        this.portaoProducerService = portaoProducerService;
    }

    @PostMapping("/comando")
    public ResponseEntity<String> enviarComando(@RequestBody PortaoDTO portaoDTO) {
        try {
            portaoProducerService.enviarComando(portaoDTO);
            return ResponseEntity.ok("Comando de portão enviado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Erro ao enviar comando: " + e.getMessage());
        }
    }

    @PostMapping("/comando/rapido")
    public ResponseEntity<String> enviarComandoRapido(
            @RequestParam String acao,
            @RequestParam String idDispositivo,
            @RequestParam int area) {
        
        try {
            PortaoDTO portaoDTO = new PortaoDTO();
            portaoDTO.setAcao(acao);
            portaoDTO.setIdDispositivo(idDispositivo);
            portaoDTO.setArea(area);
            
            portaoProducerService.enviarComando(portaoDTO);
            return ResponseEntity.ok("Comando rápido de portão enviado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Erro ao enviar comando rápido: " + e.getMessage());
        }
    }
}