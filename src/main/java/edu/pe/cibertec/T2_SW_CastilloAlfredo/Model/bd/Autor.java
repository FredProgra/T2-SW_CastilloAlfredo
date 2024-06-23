package edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idautor;
    private String nomautor;
    private String apeautor;
    private String fechnacautor;


}
