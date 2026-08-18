package com.example.FileManagementSpringbootapp8.repository;

import com.example.FileManagementSpringbootapp8.entity.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDocumentRepo extends JpaRepository<FileDocument,Long> {

}
