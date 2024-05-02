
package com.example.demospring.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demospring.Employe.Employe;
import com.example.demospring.Employe.EmployeRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeRepository rep;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employe emp = rep.findByEmail(username);
        if (emp == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println(">>>>role:" + emp.getRole());
        authorities.add(new SimpleGrantedAuthority(emp.getRole())); // Assumant que les rôles ont une méthode pour obtenir
        return new User(emp.getEmail(), emp.getMotdepass(), authorities);
    }
    private Collection<GrantedAuthority> mep(List<String> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }
    @Bean
    public AuthenticationManager authenticate(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }
}