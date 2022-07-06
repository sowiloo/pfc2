package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.FetchType;
//import javax.persistence.OneToOne;


//import org.springframework.validation.annotation.Validated;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.appasso.projet.Model.Projet;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDoc;
	@Column
	private String contratProjet;
	@Column
	private String declarationsFiscale;
	@Column
	private String demandePaiment;
	@Column
	private String rapportActivite;
	@Column
	private String rapportFinancier;
	@Column
	private String supportCom;
	@Column
	private Boolean statutDoc;






}
