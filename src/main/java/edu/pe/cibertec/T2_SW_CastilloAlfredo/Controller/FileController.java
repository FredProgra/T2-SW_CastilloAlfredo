package edu.pe.cibertec.T2_SW_CastilloAlfredo.Controller;

import edu.pe.cibertec.T2_SW_CastilloAlfredo.Model.dto.ArchivoDto;
import edu.pe.cibertec.T2_SW_CastilloAlfredo.Service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/files")
@AllArgsConstructor
public class FileController {
    private FileService fileService;
    @PostMapping("")
    public ResponseEntity<ArchivoDto> subirArchivo(@RequestParam("files") List<MultipartFile> multipartFileList) throws Exception{
        fileService.GuardarArchivos(multipartFileList);
        return  new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivos subidos correctamente").build(), HttpStatus.OK);
    }
}