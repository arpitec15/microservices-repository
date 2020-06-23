package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Orders;

public interface UsersRepository extends JpaRepository<Orders, Integer> {
	
	Orders findById(Integer id);
}
