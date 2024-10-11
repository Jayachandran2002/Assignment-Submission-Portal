package com.Backend_Intern_Assignment.assignment.submission.portal.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Backend_Intern_Assignment.assignment.submission.portal.Models.User;
import com.Backend_Intern_Assignment.assignment.submission.portal.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
    
    public List<User> getAllAdmins() {
        return userRepository.findAll().stream()
                .filter(User::isAdmin)
                .collect(Collectors.toList());
    }
}
