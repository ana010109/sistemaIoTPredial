package com.produtorLuz.luz.dto;

import lombok.Data;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO que representa o comando de luz com ID da área.
 */
@Data
public class LuzDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // Ação principal a ser executada (ex: "ON", "OFF")
    private String acao; 
    private String idDispositivo; 
    private int area; 
    private Instant timestamp = Instant.now(); 
}