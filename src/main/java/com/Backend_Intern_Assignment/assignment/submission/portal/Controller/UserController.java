package com.Backend_Intern_Assignment.assignment.submission.portal.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Backend_Intern_Assignment.assignment.submission.portal.Models.Assignment;
import com.Backend_Intern_Assignment.assignment.submission.portal.Models.User;
import com.Backend_Intern_Assignment.assignment.submission.portal.Service.AssignmentService;
import com.Backend_Intern_Assignment.assignment.submission.portal.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        user.setAdmin(false);
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(401).build();
    }
    
    // Upload an assignment
    @PostMapping("/upload")
    public ResponseEntity<Assignment> uploadAssignment(@RequestBody Assignment assignment) {
        Assignment uploadedAssignment = assignmentService.uploadAssignment(assignment);
        return ResponseEntity.ok(uploadedAssignment);
    }

    // Fetch all admins
    @GetMapping("/admins")
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> admins = userService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }
}
