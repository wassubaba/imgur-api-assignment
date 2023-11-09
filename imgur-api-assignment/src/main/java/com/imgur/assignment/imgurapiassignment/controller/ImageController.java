package com.imgur.assignment.imgurapiassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imgur.assignment.imgurapiassignment.model.UserDetails;
import com.imgur.assignment.imgurapiassignment.service.UserService;

@RestController
public class ImageController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUserDetails")
	public UserDetails saveUser(@RequestBody UserDetails userDetails) {
		return userService.createUser(userDetails);
	}
	
	@GetMapping("/getUserDetails/{id}")
	public UserDetails getUserDetailsById(@PathVariable int id) {
		return userService.getUserDetailsById(id);
	}
	
	@PostMapping("/saveMultipleUserDetails")
	public List<UserDetails> saveUserList(@RequestBody List<UserDetails> userDetailsList) {
		return userService.createUserList(userDetailsList);
	}
	
	@GetMapping("/getAllUsers")
	public List<UserDetails> getAllUsers(){
		return userService.getAllUserDetails();
	}
	
	@PutMapping("/updateUser")
	public UserDetails updateUser(@RequestBody UserDetails userDetails) {
		return userService.updateUser(userDetails);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	
}
