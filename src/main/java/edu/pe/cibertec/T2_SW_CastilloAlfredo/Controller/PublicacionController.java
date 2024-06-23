package edu.pe.cibertec.T2_SW_CastilloAlfredo.Controller;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Exception.ResourceNotFoundException;
import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Autor;
import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Publicacion;
import edu.pe.cibertec.T2_SW_CastilloAlfredo.Service.IPublicacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/publicacion")
public class PublicacionController {
    private IPublicacionService publicacionService;
    @GetMapping("")
    public ResponseEntity<List<Publicacion>> publicacionListResponse(){
        List<Publicacion> publicacionList=new ArrayList<>(publicacionService.lisPublicacions());
        if (publicacionList.isEmpty()){new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        return  new ResponseEntity<>(publicacionList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> buscarPublicacoionId(@PathVariable Integer id){
        Publicacion idpublicacion=publicacionService.publicacionxID(id).orElseThrow(
                ()->new ResourceNotFoundException("El id de la publicacion"+id+"No existe")

        );
        return  new ResponseEntity<>(idpublicacion,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Publicacion> agregarpublicacionResponse(@RequestBody Publicacion publicacion){
        return new ResponseEntity<>(publicacionService.agregarpublicaciom(publicacion),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacionResponse(
            @PathVariable Integer id,
            @RequestBody Publicacion publicacion
    ){
        Publicacion newpublicacion = publicacionService.publicacionxID(id).orElseThrow(() -> new ResourceNotFoundException("La publicaccion con Id "
                        + id +" no existe"));
        newpublicacion.setTitulo(publicacion.getTitulo());
        newpublicacion.setResumen(publicacion.getResumen());
        newpublicacion.setFechpublicacion(publicacion.getFechpublicacion());
        newpublicacion.setIdautor(publicacion.getIdautor());


        return new ResponseEntity<>(publicacionService.agregarpublicaciom(newpublicacion),
                HttpStatus.OK);
    }


}
