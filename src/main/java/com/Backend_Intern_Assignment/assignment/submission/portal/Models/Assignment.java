package com.Backend_Intern_Assignment.assignment.submission.portal.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.LocalDateTime;

@Document(collection = "assignments")
@Data
public class Assignment {
    @Id
    private String id;
    private String userId;
    private String task;
    private String adminId;
    private String status; // Accepted, Rejected, Pending
    private LocalDateTime submissionTime;

}
