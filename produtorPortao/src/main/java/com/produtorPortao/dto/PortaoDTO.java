package com.produtorPortao.dto;

import lombok.Data;
import java.io.Serializable;
import java.time.Instant;

@Data
public class PortaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String acao;
    private String idDispositivo; 
    private int area; 
    private Instant timestamp = Instant.now();

}