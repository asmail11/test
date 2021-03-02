
package org.capiskinserver.security.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.domain.hair.modal.Command;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;
    
    private String gender;
    
    private String birthDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    
    private boolean admin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Category> categories;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)    
    private List<Command> commands;

    public User() {}

    public  User(@NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 100) String password,
			String gender, String birthDate, Date createAt) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.createAt = createAt;
	}

	public  Long getId() {
        return id;
    }

    public  void setId(Long id) {
        this.id = id;
    }

    public  String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
        this.username = username;
    }

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  String getEmail() {
        return email;
    }

    public  void setEmail(String email) {
        this.email = email;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    public  String getGender() {
		return gender;
	}

	public  void setGender(String gender) {
		this.gender = gender;
	}


	public  String getBirthDate() {
		return birthDate;
	}

	public  void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public  Date getCreateAt() {
		return createAt;
	}

	public  void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public  Set<Role> getRoles() {
        return roles;
    }

    public  void setRoles(Set<Role>  roles) {
        this.roles = roles;
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
    	if (getCategories()==null) {
			this.categories=new ArrayList<>();
		}
    	getCategories().add(category);
    	category.setUser(this);
    }
	public void addCommand(Command command) {
		if (getCommands()==null) {
			this.commands = new ArrayList<>();
		}
		getCommands().add(command);
		command.setUser(this);
	}
}
