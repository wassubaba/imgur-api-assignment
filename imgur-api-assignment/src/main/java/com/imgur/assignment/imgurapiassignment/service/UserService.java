package com.imgur.assignment.imgurapiassignment.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imgur.assignment.imgurapiassignment.dao.ImageRepository;
import com.imgur.assignment.imgurapiassignment.dao.UserRepository;
import com.imgur.assignment.imgurapiassignment.exception.EmptyInputException;
import com.imgur.assignment.imgurapiassignment.model.ImageDetails;
import com.imgur.assignment.imgurapiassignment.model.UserDetails;

@Service
public class UserService {
	
	@Autowired(required=true)
	private UserRepository userRepository;
	
	@Autowired(required=true)
	private ImageRepository imageRepository;
	
	public UserDetails createUser(UserDetails userDetails) {
		
		if (userDetails.getUserName().isEmpty() || userDetails.getUserName().length() == 0) {
			throw new EmptyInputException("400", "Input Fields are empty");
		}
		return userRepository.save(userDetails);
	}
	
	public UserDetails getUserDetailsById(int id) {
		return userRepository.findById(id);
	}
	
	public List<UserDetails> getAllUserDetails(){
		return userRepository.findAll();
	}
	
	public UserDetails updateUser(UserDetails userDetails) {
		UserDetails oldUser = null;
		Optional<UserDetails> optionalUser = Optional.ofNullable(userRepository.findById(userDetails.getId()));
		if(optionalUser.isPresent()) {
			oldUser=optionalUser.get();
			oldUser.setUserName(userDetails.getUserName());
			oldUser.setEmailAdd(userDetails.getEmailAdd());
			oldUser.setImgDetails(userDetails.getImgDetails());
			userRepository.save(oldUser);
		}else {
			return new UserDetails();
		}
		return oldUser;
	}
	
	public void deleteUserById(int id) {
		Optional<UserDetails> optionalUser = Optional.ofNullable(userRepository.findById(id));
		if(optionalUser.isPresent()) {
			userRepository.deleteById(id);
		} else
		{
			throw new NoSuchElementException();
		}
	}

	public String deleteUserImageById(int id, int imgId) {
		
		if(!userRepository.existsById(id)) {
			throw new NoSuchElementException();
		}
		
		Optional<ImageDetails> imageDetails = Optional.ofNullable(imageRepository.findById(imgId));
		if(imageDetails.isPresent()) {
			imageRepository.deleteById(imgId);
		} else {
			throw new NoSuchElementException();
		}
		return "Image Got Deleted!!!";
	}

}
