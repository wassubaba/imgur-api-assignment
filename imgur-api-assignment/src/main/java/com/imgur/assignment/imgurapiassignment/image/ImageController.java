package com.imgur.assignment.imgurapiassignment.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imgur.assignment.imgurapiassignment.dao.UserRepository;
import com.imgur.assignment.imgurapiassignment.model.UserDetails;

@RestController
public class ImageController {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/saveUserDetails")
	public String saveUser(@RequestBody UserDetails userDetails) {
		repository.save(userDetails);
		return "UserDetails are saved in H2 InMemory DB";
	}
	
	@GetMapping("/getAllUserDetails")
	public List<UserDetails> getAllUserDetails(){
		return repository.findAll();
	}
	
	@GetMapping("/getUserDetails/{id}")
	public List<UserDetails> getUserDetailsById(@PathVariable Integer id){
		return repository.findById(id);
	}
	
}
