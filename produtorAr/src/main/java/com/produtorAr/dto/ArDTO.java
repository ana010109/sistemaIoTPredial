package com.produtorAr.dto;

import java.io.Serializable;
import java.time.Instant;
import lombok.Data;

@Data
public class ArDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String acao; 
    private String idDispositivo; 
    private int area; 
    private Instant timestamp = Instant.now(); 
    private Integer temperatura;

}