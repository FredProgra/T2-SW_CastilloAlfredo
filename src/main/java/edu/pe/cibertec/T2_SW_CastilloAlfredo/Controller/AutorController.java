package edu.pe.cibertec.T2_SW_CastilloAlfredo.Controller;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Exception.ResourceNotFoundException;
import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.bd.Autor;
import edu.pe.cibertec.T2_SW_CastilloAlfredo.Service.IAutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/autor")
public class AutorController {
    private IAutorService autorService;
    @GetMapping("")
    public ResponseEntity<List<Autor>> autorListResponse(){
        List<Autor> autorList=new ArrayList<>(autorService.autoreslista());
        if (autorList.isEmpty()){return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        return new ResponseEntity<>(autorList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutoridResponse(@PathVariable Integer id){
        Autor autornuevo=autorService.buscarAutorXiD(id).orElseThrow(
                ()-> new ResourceNotFoundException("El id del autor"+id+"no existe")
        );
        return new ResponseEntity<>(autornuevo,HttpStatus.OK);

    }
    @PostMapping("")
    public ResponseEntity<Autor> agregarAutorResponse(@RequestBody Autor autor){
        return new ResponseEntity<>(autorService.agregarAutor(autor),HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutorResponse(
            @PathVariable Integer id,
            @RequestBody Autor autor
    ){
        Autor newautor = autorService.buscarAutorXiD(id)
                .orElseThrow(() -> new ResourceNotFoundException("El autor con Id "
                        + id +" no existe"));
        newautor.setNomautor(autor.getNomautor());
        newautor.setApeautor(autor.getApeautor());
        newautor.setFechnacautor(autor.getFechnacautor());

        return new ResponseEntity<>(
                autorService.agregarAutor(newautor),
                HttpStatus.OK);
    }


}
