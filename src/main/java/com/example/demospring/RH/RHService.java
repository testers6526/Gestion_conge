package com.example.demospring.RH;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring.departement.Departement;
import com.example.demospring.manager.Manager;



@Service
public class RHService {
	
	private final RHRepository rhrep;

	@Autowired
	public RHService(RHRepository rhrep) {
		this.rhrep = rhrep;
	}

	//create comtpe
			public  void createRH(String nom,String prenom,String email, String motdepass,Departement dept, int solde) {
				RH empp = new RH( nom, prenom, email, motdepass,solde ,dept);
				rhrep.save(empp);
			}

			//modify compte 
			  public void modifyRH(Long id,String nom,String prenom,String email, String
				  motdepass,Departement iddept, int solde) {
				  Optional<RH> empmod = rhrep.findById(id);
				  empmod.get().setNom(nom);
				  empmod.get().setPrenom(prenom);
				  empmod.get().setEmail(email); 
				  empmod.get().setMotdepass(motdepass);
				  empmod.get().setDept_id(iddept);
				  empmod.get().setSoldeconge(solde);
				  rhrep.save(empmod.get()); 
				  }
			 
				//supprimmer
				public void deleteRH(Long id) {
					rhrep.deleteById(id);
				}
				
				public List<RH> findallrh(){
					return rhrep.findAll();
				}
				
				public Optional<RH> findallmanagerid(Long id){
					return rhrep.findById(id);
				}
				
				

}
