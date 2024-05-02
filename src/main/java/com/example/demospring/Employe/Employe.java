package com.example.demospring.Employe;


import java.util.ArrayList;
import java.util.List;

import com.example.demospring.Conge.Conge;
import com.example.demospring.Demande.Demande;
import com.example.demospring.departement.Departement;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
public  class Employe {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected Long id ;
		protected String nom;
		protected String prenom;
		protected String email;
		protected String motdepass;
		protected int Soldeconge;
		
	    @Column(name= "role",insertable=false, updatable=false) // error of adding/updating/delettin
	    protected String role; 
	    
	    @ManyToOne
	    @JoinColumn(name = "dept_id") // many employes to one departemebt
		protected Departement dept_id;
		
		@OneToMany (mappedBy = "emp")
		protected List<Demande> demandes;
		
		@OneToMany(mappedBy="emp")
		protected List<Conge> conges;
		
		public Employe() {
               
		}

		public String getNomPrenom() {
			return this.nom + " " +this.prenom;
		}
			
		public Employe(String nom,String prenom, String email, 
						String motdepass, Departement dept_id,
						int soldeconge) {
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.motdepass = motdepass;
			this.dept_id = dept_id;
			Soldeconge = soldeconge;
		}
			
		public String getRole() {
			return role;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMotdepass() {
			return motdepass;
		}

		public void setMotdepass(String motdepass) {
			this.motdepass = motdepass;
		}

		public Departement getDept_id() {
			return dept_id;
		}

		public void setDept_id(Departement dept_id) {
			this.dept_id = dept_id;
		}

		public int getSoldeconge() {
			return Soldeconge;
		}

		public void setSoldeconge(int soldeconge) {
			Soldeconge = soldeconge;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


}
