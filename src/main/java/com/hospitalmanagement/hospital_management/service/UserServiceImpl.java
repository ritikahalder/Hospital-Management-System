package com.hospitalmanagement.hospital_management.service;

import com.hospitalmanagement.hospital_management.entity.User;
import com.hospitalmanagement.hospital_management.exception.DuplicateEmailException;
import com.hospitalmanagement.hospital_management.exception.NotFoundException;
import com.hospitalmanagement.hospital_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id)
    {
        if(userRepository.findById(id).isEmpty())
            throw new NotFoundException("Requested user does not exist");
        return userRepository.findById(id);
    }


    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("A user with this email " + user.getEmail() + " already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

}
