package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import javax.persistence.Id;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Association {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column
	private String Presentation;
	@Column
	private String statutAsso;

}
