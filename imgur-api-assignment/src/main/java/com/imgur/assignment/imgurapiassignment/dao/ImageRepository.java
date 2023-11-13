package com.imgur.assignment.imgurapiassignment.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imgur.assignment.imgurapiassignment.model.ImageDetails;


@Repository
@Transactional
public interface ImageRepository extends JpaRepository<ImageDetails, Integer>{
	
	void deleteById(Integer id);
	
	ImageDetails findById(Integer id);
}
