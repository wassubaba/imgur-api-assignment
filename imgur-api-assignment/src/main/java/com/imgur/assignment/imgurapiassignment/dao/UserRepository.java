package com.imgur.assignment.imgurapiassignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imgur.assignment.imgurapiassignment.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	List<UserDetails> findById(Integer id);
	
}
