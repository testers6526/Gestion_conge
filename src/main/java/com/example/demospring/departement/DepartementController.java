package com.example.demospring.departement;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartementController {
		private final DepartementService ser;

		public DepartementController(DepartementService ser) {
			this.ser = ser;
		}
		//wont isnert name
		@PostMapping("/add")
		public void addept(@RequestBody Departement dept) {
			ser.adddepartement(dept);
		}
		
		@GetMapping("/all")
		
		public List<Departement> getdept(){
			return ser.showdepartement();
		}
		
}
