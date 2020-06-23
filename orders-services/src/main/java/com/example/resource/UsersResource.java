package com.example.resource;

import com.example.model.Orders;
import com.example.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;
    
    
    @GetMapping(value = "/{id}")
    public Orders retrieveUser(@PathVariable int id) {
        return usersRepository.findById(id);
    }
    

    @GetMapping(value = "/all")
    public List<Orders> getAll() {
        return usersRepository.findAll();
    }

   
    }


