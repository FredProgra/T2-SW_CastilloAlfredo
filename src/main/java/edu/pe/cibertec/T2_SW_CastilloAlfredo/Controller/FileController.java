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

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/files")
@AllArgsConstructor
public class FileController {
    private FileService fileService;
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "png", "docx");
    @PostMapping("")
    public ResponseEntity<ArchivoDto> subirArchivo(@RequestParam("files") List<MultipartFile> multipartFileList) throws Exception{
        fileService.GuardarArchivos(multipartFileList);
        return  new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivos subidos correctamente").build(), HttpStatus.OK);
    }
    @PostMapping("/uploadMultiple")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        if (files.length != 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debe subir exactamente 3 archivos.");
        }

        for (MultipartFile file : files) {
            String fileExtension = getFileExtension(file.getOriginalFilename());
            if (!ALLOWED_EXTENSIONS.contains(fileExtension)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todos los archivos deben ser pdf, png, o docx.");
            }
        }



        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos exitosamente.");
    }
    private String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        String[] parts = fileName.split("\\.");
        return parts.length > 1 ? parts[parts.length - 1] : null;
    }
}