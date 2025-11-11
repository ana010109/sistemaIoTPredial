// src/main/java/com/produtorAr/ar/dto/ComandoArDTO.java
package com.produtorAr.dto;

import java.io.Serializable;
import java.time.Instant;

// Implementação manual para evitar o erro do Lombok no VS Code
public class ArDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // Ação principal (ex: "LIGAR", "DESLIGAR", "AUMENTAR", "BAIXAR", "SETAR")
    private String acao; 

    // Temperatura alvo, usada apenas se acao for "SETAR"
    // Usamos Integer para permitir null se a ação for apenas LIGAR/DESLIGAR
    private Integer temperatura; 

    // ID da Área (int, para métricas)
    private int area; 

    // Identificador único do dispositivo de ar-condicionado
    private String idDispositivo; 
    
    // Data/hora da criação do comando
    private Instant timestamp = Instant.now(); 
    
    // Construtor vazio
    public ArDTO() {}

    // GETTERS E SETTERS MANUAIS (para compatibilidade com seu ambiente)
    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }
    
    public Integer getTemperatura() { return temperatura; }
    public void setTemperatura(Integer temperatura) { this.temperatura = temperatura; }
    
    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }

    public String getIdDispositivo() { return idDispositivo; }
    public void setIdDispositivo(String idDispositivo) { this.idDispositivo = idDispositivo; }
    
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}