package edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpublicacion;
    private String titulo;
    private String resumen;
    private String fechpublicacion;
    private Integer idautor;

}
