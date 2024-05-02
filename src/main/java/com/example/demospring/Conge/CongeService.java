package com.example.demospring.Conge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring.Demande.Demande;
import com.example.demospring.Demande.DemandeRepository;
import com.example.demospring.Email.EmailService;
import com.example.demospring.Employe.Employe;


@Service
public class CongeService {
		private final CongeRepository repcong;
		private final DemandeRepository repdem;
		private final EmailService email;

		@Autowired
		public CongeService(CongeRepository repcong, DemandeRepository repdem2,EmailService email) {
			this.repcong = repcong;
			this.repdem = repdem2;
			this.email= email;
		}
		
		public Map<String,Object> getconge(){
			List<Conge> list =	repcong.findAll();
			Map<String,Object> mp = new HashMap<>();
			ArrayList<Object> info = new ArrayList<>();
			for (Conge c : list) {
				Conge rh = c;
				info.add(rh.getMotif());
				info.add(rh.getDate_debut());
				info.add(rh.getDate_fin());
				info.add(rh.getNombre_jours());
				mp.put(rh.getEmp().getNomPrenom(),info);
			}
			return mp;
		}
		
		
		  public void gererdemandes(String choix, Long de) {
			  Optional<Demande> demande = repdem.findById(de);
		        System.out.println(demande.get().getMotif()+demande.get().getDate_debut()+demande.get().getDate_fin()+demande.get().getEmp());
		        if ("accepted".equals(choix)) {
		            Conge conge = new Conge(demande.get().getMotif(),demande.get().getDate_debut(),demande.get().getDate_fin(),demande.get().getEmp());
		            repcong.save(conge);
		       email.sendEmail(demande.get().getEmp().getEmail(), "Status de votre demande de conge", "Votre demande de conge a été accepter ");
		       repdem.delete(demande.get());
		          
		  }
		        else {
		        	repdem.delete(demande.get());
		        	email.sendEmail(demande.get().getEmp().getEmail(), "Status de votre demande de conge", "Votre demande de conge a été refuser ");
		        }
		  }
}
		 

