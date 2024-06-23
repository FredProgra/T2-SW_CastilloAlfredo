package edu.pe.cibertec.T2_SW_CastilloAlfredo.Service;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Autor;
import edu.pe.cibertec.T2_SW_CastilloAlfredo.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IAutorService{
    private AutorRepository autorRepository;
    @Override
    public List<Autor> autoreslista() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> buscarAutorXiD(Integer id) {
        Optional<Autor> autorOptional=autorRepository.findById(id);
        if (autorOptional.isEmpty()){ return Optional.empty();}
        return  autorOptional;

    }

    @Override
    public Autor agregarAutor(Autor autor) {
        return autorRepository.save(autor);
    }
}
