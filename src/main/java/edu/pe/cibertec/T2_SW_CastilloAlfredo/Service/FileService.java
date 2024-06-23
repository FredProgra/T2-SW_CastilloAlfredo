package edu.pe.cibertec.T2_SW_CastilloAlfredo.Service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService implements IFileService{
    private final Path pathFolder= Paths.get("upsloads");
    @Override
    public void GuardarArchivo(MultipartFile archivo)throws Exception {
        Files.copy(archivo.getInputStream(),this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void GuardarArchivos(List<MultipartFile> archivosList) throws Exception {

        for(MultipartFile archivo : archivosList){
            this.GuardarArchivo(archivo);
        }
    }
}
