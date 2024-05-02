package com.example.demospring.Demande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemandeController {
	 
		private final DemandeService emp;
		@Autowired
		public DemandeController(DemandeService emp) { this.emp = emp;}
		
	//wprls
	@GetMapping("/demandes")
	public List<Demande> getdemande(){
			return emp.voirdemande();
	}
	
	//works
	@PostMapping("/effectuerdemande")
	public void setdemande (@RequestBody Demande demande) {
		    emp.createdemande(demande.getMotif(),demande.getStatus() ,demande.getDate_debut(), demande.getDate_fin(), demande.getEmp());	
	}

}
