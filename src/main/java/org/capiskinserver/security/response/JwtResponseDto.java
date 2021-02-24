package org.capiskinserver.security.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

//change email for name at 08/06
public class JwtResponseDto {
	
	  private String token;
	  private String type = "Bearer";
	  private Long id;
	  private String name;
	  private String email;
	  private String username;
	  private Collection<? extends GrantedAuthority> authorities;
	  
	  public JwtResponseDto(String accessToken, Long id,  String name, String email,  String username, Collection<? extends GrantedAuthority> authorities) {
		    this.token = accessToken;
		    this.id = id;
		  	this.name = name;
		    this.email = email;
		    this.username = username;
		    this.authorities = authorities;
		  }
		 
	  
		  public String getAccessToken() {
		    return token;
		  }
		 
		  public void setAccessToken(String accessToken) {
		    this.token = accessToken;
		  }
		 
		  
		  public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTokenType() {
		    return type;
		  }
		 
		  public void setTokenType(String tokenType) {
		    this.type = tokenType;
		  }
		  
		  
		  public String getName() {
		    return name;
		  }
			 
		  public void setName(String name) {
		    this.name = name;
		  }
		 
	      public String getEmail() {
			return email;
		  }
	
	
		  public void setEmail(String email) {
			this.email = email;
		  }
		 
		  public String getUsername() {
		    return username;
		  }
		 
		  public void setUsername(String username) {
		    this.username = username;
		  }
		  
		  public Collection<? extends GrantedAuthority> getAuthorities() {
		    return authorities;
		  }
}