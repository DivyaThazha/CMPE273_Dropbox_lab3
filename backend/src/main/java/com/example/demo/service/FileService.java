package com.example.demo.service;

import com.example.demo.entity.Files;
import com.example.demo.entity.User;
import com.example.demo.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FilesRepository filesRepository;

    public List<Files> getAllFiles(String username) {

        System.out.println("In file service: "+username);
        return filesRepository.findByUsername(username);
    }

    public void addFile (Files file) {
        filesRepository.save(file);
    }

}
