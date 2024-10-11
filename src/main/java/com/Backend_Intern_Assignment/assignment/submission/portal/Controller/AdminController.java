package com.Backend_Intern_Assignment.assignment.submission.portal.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Backend_Intern_Assignment.assignment.submission.portal.Models.Assignment;
import com.Backend_Intern_Assignment.assignment.submission.portal.Models.User;
import com.Backend_Intern_Assignment.assignment.submission.portal.Service.AssignmentService;
import com.Backend_Intern_Assignment.assignment.submission.portal.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        user.setAdmin(true);
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInAdmin = userService.login(user.getUsername(), user.getPassword());
        if (loggedInAdmin != null && loggedInAdmin.isAdmin()) {
            return ResponseEntity.ok(loggedInAdmin);
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAssignments(@RequestParam String adminId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsForAdmin(adminId));
    }

    @PostMapping("/assignments/{id}/accept")
    public ResponseEntity<Assignment> acceptAssignment(@PathVariable String id) {
        return ResponseEntity.ok(assignmentService.acceptAssignment(id));
    }

    @PostMapping("/assignments/{id}/reject")
    public ResponseEntity<Assignment> rejectAssignment(@PathVariable String id) {
        return ResponseEntity.ok(assignmentService.rejectAssignment(id));
    }
}
