package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//import javax.persistence.Id;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer userID;
	@Column
	@NotBlank
	@Size(max = 60)
	@Email
	private String Mail;
	@Column
	private String Password;
	@Column
	private int Telephone;
	@Column
	private String Role;
	@Column
	private String Photo;
	@Column
	private boolean isdocValid;


}