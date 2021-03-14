
package org.capiskinserver.security.message.request;

import java.util.Set;
import javax.validation.constraints.*;

public class SignupRequest {

	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String username;

	@NotBlank
	@NotNull
	@NotEmpty
	@Size(max = 60)
	@Email
	private String email;

	private Set<String> role;

	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 6, max = 100)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

}
