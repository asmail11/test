package org.capiskinserver.security.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDto {
		
	    @Size(min=3, max = 60)
	    private String name;
	
	    @NotBlank
	    @NotNull
	    @Size(max = 60)
	    @Email
	    private String email;

	    @Size(min=3, max = 60)
	    private String username;
	 
	    @NotBlank
	    @Size(min = 6, max = 40)
	    private String password;

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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    

}
