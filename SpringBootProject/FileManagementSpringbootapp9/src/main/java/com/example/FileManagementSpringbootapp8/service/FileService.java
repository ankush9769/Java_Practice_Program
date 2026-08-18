package com.example.FileManagementSpringbootapp8.service;

import com.example.FileManagementSpringbootapp8.dto.FileResponse;
import com.example.FileManagementSpringbootapp8.entity.FileDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    FileResponse uploadFile(MultipartFile file) throws IOException;

    List<FileResponse> uploadMultipleFiles(MultipartFile[] files) throws IOException;

    List<FileResponse> getAllFiles();

    FileDocument downloadFile(Long id);

    void deleteFile(Long id);


}
