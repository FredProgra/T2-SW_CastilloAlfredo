package edu.pe.cibertec.T2_SW_CastilloAlfredo.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
