package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "ar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String acao; // "LIGAR", "DESLIGAR", "AUMENTAR_TEMP", "DIMINUIR_TEMP"
    
    private Double temperatura; // Nova temperatura desejada (Ex: 23.5)
    
    @Column(name = "id_dispositivo", nullable = false)
    private String idDispositivo; 
    
    private int area; 
    
    @Column(name = "timestamp_registro")
    private Instant timestamp;
}