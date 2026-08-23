package com.example.AssignmentTrackingSpringBootApp11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;

    private Long studentId;

    private String submissionText;

    private Date submittedAt;

    private Integer marks;

    private String feedback;

    @Enumerated(EnumType.STRING)
    private SubmissionStatus status;

    private Date evaluatedAt;
}
