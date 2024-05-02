package com.example.demospring.manager;


import com.example.demospring.Employe.Employe;
import com.example.demospring.departement.Departement;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("manager")
public class Manager extends Employe{

	
	public Manager() {
	}

	public Manager( String nom, String prenom, String email, String motdepass,  Departement dept_id,
			int soldeconge) {
		super( nom, prenom, email, motdepass, dept_id, soldeconge);
	}

}
