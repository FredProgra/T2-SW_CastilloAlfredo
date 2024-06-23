package edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class MensajeErrorDto {
    private  Integer codigo;
    private Date fechaError;
    private String mensaje;
    private String description;
}