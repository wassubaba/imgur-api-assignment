package com.imgur.assignment.imgurapiassignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String emailAdd;
	private String password;
	private String image;
}
