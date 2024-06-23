package edu.pe.cibertec.T2_SW_CastilloAlfredo.Service;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Autor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IAutorService {
    List<Autor> autoreslista();
    Optional<Autor> buscarAutorXiD(Integer id);
    Autor agregarAutor(Autor autor);
}
