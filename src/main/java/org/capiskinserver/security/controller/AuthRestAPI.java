package org.capiskinserver.security.controller;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.capiskinserver.mailling.service.EmailService;
import org.capiskinserver.security.dao.RoleRepository;
import org.capiskinserver.security.dao.UserRepository;
import org.capiskinserver.security.jwt.JwtProvider;
import org.capiskinserver.security.modal.Role;
import org.capiskinserver.security.modal.RoleName;
import org.capiskinserver.security.modal.User;
import org.capiskinserver.security.request.LoginFormDto;
import org.capiskinserver.security.request.SignUpFormDto;
import org.capiskinserver.security.response.JwtResponseDto;
import org.capiskinserver.security.response.ResponseMessageDto;
import org.capiskinserver.security.service.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPI {

	  @Autowired
	  AuthenticationManager authenticationManager;
	 
	  @Autowired
	  UserRepository userRepository;
	 	  
	 
	  @Autowired
	  RoleRepository roleRepository;
	 
	 
	  @Autowired
	  PasswordEncoder encoder;
	 
	  @Autowired
	  JwtProvider jwtProvider;
	  
	  @Autowired
	  private EmailService service;
	  
	  
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginFormDto loginRequest) {
	 
	    Authentication authentication = authenticationManager.authenticate((Authentication) (
	        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())));
	 
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	     

	    //AppUser user = (AppUser) 
	    		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	    String jwt = jwtProvider.generateJwtToken(authentication);
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	
	
	    return ResponseEntity.ok(new JwtResponseDto(jwt, userDetails.getId(),  userDetails.getName(), loginRequest.getEmail(),  userDetails.getUsername(), userDetails.getAuthorities()));
	  }
	 
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpFormDto signUpRequest) {
		  
		  
		  if(!signUpRequest.getPassword().equals(signUpRequest.getRepassword()))
				throw new RuntimeException("You must confirme your password");

	 
	    // Creating user's account
	    User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
	        encoder.encode(signUpRequest.getPassword()), signUpRequest.isAdmin());
	 
	    //Get all roles
	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();
	    
	    
	    // Send email to user when account is created
		Map<String, Object> model = new HashMap<>();
		model.put("Name", signUpRequest.getName());
		model.put("location", "France,Paris");
		
		//Get user Information to send email
		signUpRequest.setTo(signUpRequest.getEmail());
		signUpRequest.getTo();
		signUpRequest.setSubject("Notification Subscription");
		signUpRequest.getSubject();
		signUpRequest.setFrom("vivaniah@gmail.com");
		signUpRequest.getFrom();
		
		service.sendEmail(signUpRequest, model);
	    
	    
	    if (strRoles == null) {
	    	Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
	    strRoles.forEach(role -> {
	      switch (role) {
	      case "admin":
	    	  Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(adminRole);
	 
	        break;
	      case "pm":
	    	  Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(pmRole);
	 
	        break;
	      default:
	    	  Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(userRole);
	      }
	    });
	  }
	    user.setRoles(roles);
	    userRepository.save(user);

 
	    return new ResponseEntity<>(new ResponseMessageDto("User registered successfully!"), HttpStatus.OK);
	}
}