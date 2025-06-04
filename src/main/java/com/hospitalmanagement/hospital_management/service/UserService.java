package com.hospitalmanagement.hospital_management.service;

import com.hospitalmanagement.hospital_management.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    boolean existsById(Long id);
}
