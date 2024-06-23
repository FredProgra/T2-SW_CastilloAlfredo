package edu.pe.cibertec.T2_SW_CastilloAlfredo.Service;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Publicacion;

import java.util.List;
import java.util.Optional;

public interface IPublicacionService {
    List<Publicacion> lisPublicacions();
    Optional<Publicacion> publicacionxID(Integer id);
    Publicacion agregarpublicaciom(Publicacion publicacion);
}
