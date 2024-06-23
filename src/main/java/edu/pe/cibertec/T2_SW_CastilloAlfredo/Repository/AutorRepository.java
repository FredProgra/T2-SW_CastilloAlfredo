package edu.pe.cibertec.T2_SW_CastilloAlfredo.Repository;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
