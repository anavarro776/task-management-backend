package com.anavarro776.taskmangment.service;
import com.anavarro776.taskmangment.model.User;
import com.anavarro776.taskmangment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List <User> findAll(){
        return userRepository.findAll();
    }
}
