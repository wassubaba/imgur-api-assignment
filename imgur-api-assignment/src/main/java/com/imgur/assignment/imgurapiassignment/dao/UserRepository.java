package com.imgur.assignment.imgurapiassignment.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imgur.assignment.imgurapiassignment.model.UserDetails;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	UserDetails findById(Integer id);

	void deleteById(Integer id);
	
}
