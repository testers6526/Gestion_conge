package com.example.demospring.departement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demospring.Employe.Employe;

@Service
public class DepartementService {
	private final DepartementRepository rep;

	public DepartementService(DepartementRepository rep) {
		this.rep = rep;
	}
	
	public List<Departement> showdepartement() {
		return rep.findAll();
	}
	
	
	public void adddepartement(Departement name) {
		Departement empp = new Departement(name.getNom_dept());
		rep.save(empp);
	}
}
