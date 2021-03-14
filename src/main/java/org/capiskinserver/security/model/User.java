
package org.capiskinserver.security.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.capiskinserver.domain.hair.modal.Command;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	@Column(unique=true)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	@Column(unique=true)
	private String email;

	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 6, max = 100)
	private String password;

	private boolean admin;
	
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToOne(cascade = CascadeType.MERGE)
    private Account account;

    @OneToOne(cascade = CascadeType.MERGE)
    private Payment payment;
 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@JsonBackReference(value = "user")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Command> commands;

	public User() {
	}

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(@NotBlank @NotNull @NotEmpty @Size(min = 3, max = 50) String username,
			@NotBlank @Size(max = 50) @Email String email,
			@NotBlank @NotNull @NotEmpty @Size(min = 6, max = 100) String password, boolean admin, Date createdAt,
			Account account, Payment payment, Set<Role> roles,
			List<Command> commands) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.createdAt = createdAt;
		this.account = account;
		this.payment = payment;
		this.roles = roles;
		this.commands = commands;
	}

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}


	public void addCommand(Command command) {
		if (getCommands() == null) {
			this.commands = new ArrayList<>();
		}
		getCommands().add(command);
		command.setUser(this);
	}

}
