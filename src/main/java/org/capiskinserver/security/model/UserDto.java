package org.capiskinserver.security.model;

import java.util.Date;
import java.util.List;

import org.capiskinserver.application.hair.dto.CommandDto;

public class UserDto {
	private String token;
	
	private String type = "Bearer";
	
	private Long id;

	private String username;

	private String email;

	private String password;

	private boolean admin;

    private Date createdAt;

    private AccountDto account;
   
    private PaymentDto payment;

	private List<CommandDto> commands;
	
	private List<String> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	public PaymentDto getPayment() {
		return payment;
	}

	public void setPayment(PaymentDto payment) {
		this.payment = payment;
	}

	public List<CommandDto> getCommands() {
		return commands;
	}

	public void setCommands(List<CommandDto> commands) {
		this.commands = commands;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
