package com.example.demospring.RH;

import com.example.demospring.Employe.Employe;
import com.example.demospring.departement.Departement;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("rh")
public class RH extends Employe{

	public RH() {
	}

	public RH(String nom, String prenom, String email, String motdepass, int soldeconge, Departement dept_id) {
		super(nom, prenom, email, motdepass, dept_id, soldeconge);
	}

}
