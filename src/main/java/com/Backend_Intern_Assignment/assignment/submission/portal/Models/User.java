package com.Backend_Intern_Assignment.assignment.submission.portal.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean isAdmin; // to distinguish between user and admin

}
