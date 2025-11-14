package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "luz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Luz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String acao;
    
    @Column(name = "id_dispositivo", nullable = false)
    private String idDispositivo; 
    
    private int area; 

    @Column(name = "timestamp_registro")
    private Instant timestamp; 
}