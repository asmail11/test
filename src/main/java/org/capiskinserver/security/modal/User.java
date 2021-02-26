package org.capiskinserver.security.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.domain.hair.modal.Command;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

	@NotBlank
	@Size(min = 3, max = 50)
	private String name;

	@Column(unique = true)
	private String username;

	@NaturalId
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	private boolean admin;

	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Role> roles = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Category> categories;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Command> commands;

	public User(@NotBlank @Size(min = 3, max = 50) String name, String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 100) String password,
			boolean admin, Collection<Role> roles, List<Category> categories, List<Command> commands) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.roles = roles;
		this.categories = categories;
		this.commands = commands;
	}

	public User(String name, String username, String email, String password, boolean admin) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public void addCategory(Category category) {
		if (getCategories() == null) {
			this.categories = new ArrayList<>();
		}
		getCategories().add(category);
		category.setUser(this);
	}

	public boolean hasCategory(String name) {
		if (getCategories() != null) {
			return getCategories().stream()
					.filter(categories -> categories.getName().toLowerCase().equals(name.toLowerCase())).findAny()
					.orElse(null) != null;
		}
		return false;
	}

	public void addCommand(Command command) {
		if (getCommands() == null) {
			this.commands = new ArrayList<>();
		}
		getCommands().add(command);
		command.setUser(this);
	}

}
