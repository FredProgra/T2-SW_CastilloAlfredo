package edu.pe.cibertec.T2_SW_CastilloAlfredo.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    void GuardarArchivo(MultipartFile archivo) throws Exception;
    void GuardarArchivos(List<MultipartFile> archivosList) throws  Exception;
}
