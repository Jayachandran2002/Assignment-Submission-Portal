package com.Backend_Intern_Assignment.assignment.submission.portal.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Backend_Intern_Assignment.assignment.submission.portal.Models.Assignment;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByAdminId(String adminId);
}
