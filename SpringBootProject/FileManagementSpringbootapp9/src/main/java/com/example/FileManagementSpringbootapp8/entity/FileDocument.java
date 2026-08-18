package com.example.FileManagementSpringbootapp8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fileName",nullable = false)
    private String fileName;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "fileSize")
    private Long fileSize;

    @Column(name="uploadTime")
    private LocalDateTime uploadTime;

    @Lob
    @Column(name = "date",columnDefinition = "LONGBLOB")
    private byte[] data;
}
