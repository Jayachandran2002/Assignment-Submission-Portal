package com.Backend_Intern_Assignment.assignment.submission.portal.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Backend_Intern_Assignment.assignment.submission.portal.Models.User;


public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
