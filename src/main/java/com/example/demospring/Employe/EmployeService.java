package com.example.demospring.Employe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring.departement.Departement;



@Service
public class EmployeService {
	
	@Autowired
	private final EmployeRepository emp;


	public EmployeService(EmployeRepository emp) {
			this.emp = emp;
	}
	
	// get employee
		public List<Employe> findallemploye(){
			return emp.findAll();
		}
		
		public Optional<Employe> findallemployeid(Long id){
			return emp.findById(id);
		}
		
		
		//create comtpe
		public  void createemployee(String nom,String prenom,String email, String motdepass, Departement dept,Integer solde) {
			  if (nom == null || prenom == null || email == null || motdepass == null || solde == null) {
		            throw new IllegalArgumentException("All parameters must not be null");
		        }
			Employe empp = new Employe( nom, prenom, email, motdepass, dept, solde);
			emp.save(empp);
		}
		
		
		//modify compte 
		public void modifyemploye(Long id,String nom,String prenom,String email, String motdepass,Departement dept, int solde) {
			Optional<Employe> empmod = emp.findById(id);
			empmod.get().setNom(nom);
			empmod.get().setPrenom(prenom);
			empmod.get().setEmail(email);
			empmod.get().setMotdepass(motdepass);
			empmod.get().setDept_id(dept);
			empmod.get().setSoldeconge(solde);
			emp.save(empmod.get());
			
		}
			//supprimmer
			public void deletecompte(Long id) {
				emp.deleteById(id);
			}
			

			public int voirsolde(Long id) {
				Optional<Employe> empl=emp.findById(id);
				if(empl.isPresent()) {
					Employe rh = empl.get();
					return rh.getSoldeconge();
					}
				else 
					return -1;
				
			}

				
			public Map<String, Integer> voirsoldeall() {
				List<Employe> empl=emp.findAll();
				Map<String, Integer> solde = new HashMap<String, Integer>();
				for (Employe emp : empl) {
					Employe rh = emp;
					solde.put(rh.getNomPrenom(),rh.getSoldeconge());
				}
				return solde;
			}

	
	
	
}
