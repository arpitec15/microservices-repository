package com.employee.db.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.db.model.Users;
import com.employee.db.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;
    
    @GetMapping(value = "/{id}")
    public Users retrieveUser(@PathVariable int id) {
        return usersRepository.findById(id);
    }
    

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Users> persist(@RequestBody final Users users) {
        usersRepository.save(users);
        return usersRepository.findAll();
    }

}
