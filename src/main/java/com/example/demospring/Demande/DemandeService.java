package com.example.demospring.Demande;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring.Employe.Employe;


@Service
public class DemandeService {
	
	private final DemandeRepository emprep;
	
			@Autowired
		public DemandeService(DemandeRepository emprep) {
				this.emprep = emprep;
		}
	
		//voir status de demande 
		public List<Demande> voirdemande() {
				return emprep.findAll();
		}
		
		//creer demande 		
		public void createdemande( String motif ,String status,Date date_debut, Date date_fin,
				Employe emp) {
			Demande demande = new Demande(motif,status ,date_debut, date_fin, emp);			     
			emprep.save(demande);
	
		}


	
		

}
