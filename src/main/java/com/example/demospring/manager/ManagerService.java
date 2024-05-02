package com.example.demospring.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring.Employe.Employe;
import com.example.demospring.Employe.EmployeRepository;
import com.example.demospring.departement.Departement;


@Service
public class ManagerService {

	@Autowired
	private final ManagerRepository manager;


	public ManagerService(ManagerRepository emp) {
			this.manager = emp;
	}
	
	// get manager
		public List<Manager> findallmanager(){
			return manager.findAll();
		}
		
		public Optional<Manager> findallmanagerid(Long id){
			return manager.findById(id);
		}
		
		
		//create comtpe
		public  void createmanager(String nom,String prenom,String email, String motdepass, Departement dept,Integer solde) {
			  if (nom == null || prenom == null || email == null || motdepass == null || solde == null) {
		            throw new IllegalArgumentException("All parameters must not be null");
		        }
			Manager empp = new Manager( nom, prenom, email, motdepass, dept, solde);
			manager.save(empp);
		}
		
		
		//modify compte 
		public void modifyManager(Long id,String nom,String prenom,String email, String motdepass, int solde, Departement dept) {
			Optional<Manager> empmod = manager.findById(id);
			empmod.get().setNom(nom);
			empmod.get().setPrenom(prenom);
			empmod.get().setEmail(email);
			empmod.get().setMotdepass(motdepass);
			empmod.get().setDept_id(dept);
			empmod.get().setSoldeconge(solde);
			manager.save(empmod.get());
			
		}
		
		
		public void deletecompte(Long id) {
			manager.deleteById(id);
		}
}
