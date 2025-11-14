package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "comando_portao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Portao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String acao; // "ABRIR", "FECHAR", "PARAR"
    
    @Column(name = "id_dispositivo", nullable = false)
    private String idDispositivo; 
    
    private int area; 
    
    @Column(name = "timestamp_registro")
    private Instant timestamp;
}