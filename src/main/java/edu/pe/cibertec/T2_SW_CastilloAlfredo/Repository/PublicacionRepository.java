package edu.pe.cibertec.T2_SW_CastilloAlfredo.Repository;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion,Integer> {
}
