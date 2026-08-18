package com.example.FileManagementSpringbootapp8.service;

import com.example.FileManagementSpringbootapp8.dto.FileResponse;
import com.example.FileManagementSpringbootapp8.entity.FileDocument;
import com.example.FileManagementSpringbootapp8.exception.FileNotFoundException;
import com.example.FileManagementSpringbootapp8.repository.FileDocumentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class FileServiceImpl implements FileService {
    private final FileDocumentRepo fileDocumentRepo;

    @Override
    public FileResponse uploadFile(MultipartFile file) throws IOException {
        validateFile(file);
        FileDocument document = FileDocument.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .fileSize(file.getSize())
                .uploadTime(LocalDateTime.now())
                .data(file.getBytes())
                .build();

        FileDocument saveDocument = fileDocumentRepo.save(document);
        return convertToResponse(saveDocument);

//        fileDocumentRepo.save(document);
//        return convertToResponse(document);
    }

    @Override
    public List<FileResponse> uploadMultipleFiles(MultipartFile[] files) throws IOException {
        List<FileResponse> responses = new ArrayList<>();

        for(MultipartFile file : files){
            FileResponse response = uploadFile(file);
            responses.add(response);
        }
        return responses;
    }

    //validationg the file
    private void validateFile(MultipartFile file){
        if(file == null || file.isEmpty()){
            throw new IllegalArgumentException("please select a file");
        }
        if(file.getOriginalFilename() == null){
            throw new IllegalArgumentException("Invalid file name");
        }
    }


    //covertign the actuall the Entity data into FileResponse onject so that it can be pass
    private FileResponse convertToResponse(FileDocument document){
        return FileResponse.builder()
                .id(document.getId())
                .fileName(document.getFileName())
                .fileType(document.getFileType())
                .fileSize(document.getFileSize())
                .uploadTime(document.getUploadTime())
                .build();
    }


    @Override
    public List<FileResponse> getAllFiles(){
        return fileDocumentRepo.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public FileDocument downloadFile(Long id) {
        return fileDocumentRepo.findById(id)
                .orElseThrow(()->
                        new FileNotFoundException("file not found id:"+id));
    }

    @Override
    public void deleteFile(Long id) {
        FileDocument file = fileDocumentRepo.findById(id)
                .orElseThrow(()->
                        new FileNotFoundException("file not found with id:"+id)
                );
        fileDocumentRepo.delete(file);
    }


}
