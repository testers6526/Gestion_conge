package com.example.demospring.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthentificationFilter extends OncePerRequestFilter{

	 @Autowired
	    private JwtTokenProvider jwtTokenProvider;

	    @Autowired
	    private CustomUserDetailsService userDetailsService;

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	            throws ServletException, IOException {
	        try {
	            // 1. Extract JWT Token
	            String token = jwtTokenProvider.resolveToken(request);

	            if (token != null && jwtTokenProvider.validateToken(token)) {
	                // 2. Extract User Information
	                String username = jwtTokenProvider.getUsernameFromToken(token);

	                // 3. Load UserDetails from Database
	                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

	                // 4. Create Authentication Object
	                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());

	                // 5. Set Authentication in Security Context
	                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	            }
	        } catch (Exception ex) {
	            logger.error("Failed to set user authentication", ex);
	        }

	        chain.doFilter(request, response);
	    }

}
