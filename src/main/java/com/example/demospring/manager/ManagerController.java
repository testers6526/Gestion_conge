package com.example.demospring.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospring.Employe.Employe;



@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	private final ManagerService man;

	@Autowired
	public ManagerController(ManagerService man) {
		this.man = man;
	}
	
	//works
	
		@PostMapping("/add")
		@PreAuthorize("hasRole('Role_Manager')")
		public void createemp(@RequestBody Employe emp) {
			man.createmanager( emp.getNom(), emp.getPrenom(), 
								emp.getEmail(), emp.getMotdepass(), 
								emp.getDept_id(), emp.getSoldeconge());

		}
		
		//works
		@PutMapping("/modify")
		@PreAuthorize("hasRole('Role_Manager')")
		public void modmanager(@RequestBody Employe emp) {
				man.modifyManager(emp.getId(), emp.getNom(), 
						          emp.getPrenom(), emp.getEmail(), emp.getMotdepass(),
						          emp.getSoldeconge(), emp.getDept_id());
		}
		
		
		//works
		@DeleteMapping("/delete/{id}")
		@PreAuthorize("hasRole('Role_Manager')")
		public void deletemanager(@PathVariable Long id) {
			man.deletecompte(id);
		}
		
		//works
		@GetMapping("/all")
		@PreAuthorize("hasRole('Role_Manager')")
		public List<Manager> getallemp() {
			return man.findallmanager();
		}
		

}

