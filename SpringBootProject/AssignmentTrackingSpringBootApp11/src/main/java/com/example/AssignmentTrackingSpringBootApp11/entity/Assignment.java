package com.example.AssignmentTrackingSpringBootApp11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate assignedDate;

    private LocalDate dueDate;

    private Integer maxMarks;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    private Long trainerId;

    private Date createdAt;

    private Date updatedAt;

}
