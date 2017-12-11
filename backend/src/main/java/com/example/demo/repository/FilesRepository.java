package com.example.demo.repository;

import com.example.demo.entity.Files;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilesRepository extends CrudRepository<Files, Long> {
    List<Files> findByUsername(String username);
}