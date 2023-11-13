package com.imgur.assignment.imgurapiassignment.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "user_fk_id"), name = "user_id")
	private Set<ImageDetails> imgDetails;
	
}
