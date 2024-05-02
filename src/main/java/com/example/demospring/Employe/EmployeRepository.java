package com.example.demospring.Employe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

	Employe findByEmail(String username);

}
