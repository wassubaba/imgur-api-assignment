package com.imgur.assignment.imgurapiassignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDetails {
	
	@Id
	private int id;
	private String imageName;
	
}
