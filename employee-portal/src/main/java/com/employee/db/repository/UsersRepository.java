package com.employee.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.db.model.*;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	Users findById(Integer id);
}
