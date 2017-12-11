package com.example.demo.repository;

import com.example.demo.entity.Userdetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserdetailsRepository extends CrudRepository<Userdetails, Long> {
    List<Userdetails> findByUsername(String username);
}