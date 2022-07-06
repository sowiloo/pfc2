package com.example.model;


//import javax.persistence.OneToOne;
//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.appasso.projet.Model.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projetId;
	@Column
	private String nomProjet;
	@Column
	private String ficheDescriptif;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PROJET_ID")
	private List<Document> documents;

	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="DOCUMENT_ID")
	private Document document;

}
