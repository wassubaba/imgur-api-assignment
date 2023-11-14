package com.imgur.assignment.imgurapiassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> saveUser(@RequestBody UserDetails userDetails) {
		UserDetails userDetailsSaved = userService.createUser(userDetails);
		return new ResponseEntity<UserDetails>(userDetailsSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserDetails/{id}")
	public ResponseEntity<?> getUserDetailsById(@PathVariable int id) {
		UserDetails userDetailsRetrieved = userService.getUserDetailsById(id);
		if (userDetailsRetrieved == null)
			return new ResponseEntity<String>("No Value is Present in DB", HttpStatus.NOT_FOUND);
		return new ResponseEntity<UserDetails>(userDetailsRetrieved, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDetails>> getAllUsers(){
		List<UserDetails> userDetailsList = userService.getAllUserDetails();
		return new ResponseEntity<List<UserDetails>>(userDetailsList, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails) {
		UserDetails userDetailsUpdated = userService.updateUser(userDetails);
		return new ResponseEntity<UserDetails>(userDetailsUpdated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteUser/{userId}/Image/{imageId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId, @PathVariable int imageId) {
		String message = userService.deleteUserImageById(userId, imageId);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}
	
}
