package com.example.seco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seco.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
