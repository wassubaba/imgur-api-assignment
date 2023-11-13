package com.imgur.assignment.imgurapiassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imgur.assignment.imgurapiassignment.dao.ImageRepository;
import com.imgur.assignment.imgurapiassignment.dao.UserRepository;
import com.imgur.assignment.imgurapiassignment.model.ImageDetails;
import com.imgur.assignment.imgurapiassignment.model.UserDetails;

@Service
public class UserService {
	
	@Autowired(required=true)
	private UserRepository repository;
	
	@Autowired(required=true)
	private ImageRepository imgRepo;
	
	public UserDetails createUser(UserDetails userDetails) {
		return repository.save(userDetails);
	}
	
	public UserDetails getUserDetailsById(int id) {
		return repository.findById(id);
	}
	
	public List<UserDetails> createUserList(List<UserDetails> userDetailsList) {
		return repository.save(userDetailsList);
	}
	
	public List<UserDetails> getAllUserDetails(){
		return repository.findAll();
	}
	
	public UserDetails updateUser(UserDetails userDetails) {
		UserDetails oldUser = null;
		Optional<UserDetails> optionalUser = Optional.ofNullable(repository.findById(userDetails.getId()));
		if(optionalUser.isPresent()) {
			oldUser=optionalUser.get();
			oldUser.setUserName(userDetails.getUserName());
			oldUser.setEmailAdd(userDetails.getEmailAdd());
			oldUser.setImgDetails(userDetails.getImgDetails());
			repository.save(oldUser);
		}else {
			return new UserDetails();
		}
		return oldUser;
	}
	
	public String deleteUserById(int id) {
		repository.deleteById(id);
		return "User Got Deleted";
	}

	public String deleteUserImageById(int id, int imgId) {
		
		if(!repository.existsById(id)) {
			return "User Id Not Found!!!";
		}
		
		Optional<ImageDetails> imageDetails = Optional.ofNullable(imgRepo.findById(imgId));
		if(imageDetails.isPresent()) {
			imgRepo.deleteById(imgId);
		} else {
			return "Image Id Not Present";
		}
		return "Image Got Deleted!!!";
	}

}
