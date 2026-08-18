package com.example.FileManagementSpringbootapp8.controller;

import com.example.FileManagementSpringbootapp8.dto.FileResponse;
import com.example.FileManagementSpringbootapp8.entity.FileDocument;
import com.example.FileManagementSpringbootapp8.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("file")MultipartFile file)throws IOException{
        FileResponse response = fileService.uploadFile(file);
        return ResponseEntity.ok(response); //here ResponseEntity is prebuild class the return the some message and code
    }

    @PostMapping(value = "/upload-multiple",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<FileResponse>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files)throws IOException{
        List<FileResponse> responses= fileService.uploadMultipleFiles(files);
        return ResponseEntity.ok(responses);
    }


    //getting all the documents
    @GetMapping
    public ResponseEntity<List<FileResponse>> getAllFiles(){
        return ResponseEntity.ok(fileService.getAllFiles());
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id){
        FileDocument file = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(
                        MediaType.parseMediaType(
                                file.getFileType()
                        )
                )
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""
                        +file.getFileName()
                        +"\"").body(file.getData()
                );
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id){
        fileService.deleteFile(id);
        return ResponseEntity.ok("file deleted successfully");
    }




}
