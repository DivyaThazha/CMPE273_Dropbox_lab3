package com.example.demo.service;

import com.example.demo.entity.Userdetails;
import com.example.demo.repository.UserdetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserdetailsService {
    @Autowired
    private UserdetailsRepository userdetailsRepository;


    public Iterable<Userdetails> getAllUsers() {
        return userdetailsRepository.findAll();
    }

    public void addUser(Userdetails user) {
        userdetailsRepository.save(user);
    }

    public List<Userdetails> getUserDetails(String email) {
        return userdetailsRepository.findByUsername(email);
    }

}
