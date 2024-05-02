package com.example.demospring.RH;

import java.util.List;

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
@RequestMapping("/rh")
public class RHController {
	
	private RHService rep ;
	
	@Autowired
	public RHController(RHService rep) {
		this.rep = rep;
	}
	
	//works
	@PostMapping("/add")
	@PreAuthorize("hasRole('Role_rh')")
	public void createemp(@RequestBody Employe emp) {
		rep.createRH( emp.getNom(), emp.getPrenom(), 
				      emp.getEmail(),emp.getMotdepass(), 
				      emp.getDept_id(), emp.getSoldeconge());
	}
	
	
	//works
	@PutMapping("/modify")
	@PreAuthorize("hasRole('Role_rh')")
	public void modmanager(@RequestBody Employe emp) {
			rep.modifyRH(emp.getId(), emp.getNom(), 
					     emp.getPrenom(), emp.getEmail(), 
					     emp.getMotdepass(), emp.getDept_id(), emp.getSoldeconge());
	}
	
	
	//works
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('Role_rh')")
	public void deletemanager(@PathVariable Long id) {
		rep.deleteRH(id);
	}
	
	//workss
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('Role_rh')")
	public List<RH> getallemp() {
		return rep.findallrh();
	}
}
