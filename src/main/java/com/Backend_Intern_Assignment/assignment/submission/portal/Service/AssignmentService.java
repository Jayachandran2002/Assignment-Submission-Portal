package com.Backend_Intern_Assignment.assignment.submission.portal.Service;

import org.springframework.stereotype.Service;

import com.Backend_Intern_Assignment.assignment.submission.portal.Models.Assignment;
import com.Backend_Intern_Assignment.assignment.submission.portal.Repository.AssignmentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment uploadAssignment(Assignment assignment) {
        assignment.setSubmissionTime(LocalDateTime.now());
        assignment.setStatus("PENDING");
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsForAdmin(String admin) {
        return assignmentRepository.findByAdminId(admin);
    }

    public Assignment acceptAssignment(String id) {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow();
        assignment.setStatus("ACCEPTED");
        return assignmentRepository.save(assignment);
    }

    public Assignment rejectAssignment(String id) {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow();
        assignment.setStatus("REJECTED");
        return assignmentRepository.save(assignment);
    }
}
