package org.capiskinserver;

import org.capiskinserver.security.WebSecurityConfig;
import org.capiskinserver.security.model.Role;
import org.capiskinserver.security.model.RoleName;
import org.capiskinserver.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;


@SpringBootApplication
public class CapiSkinServerApplication {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CapiSkinServerApplication.class, args);
		
		System.out.println("\n\n |..................................................|");
		System.out.println(" |... CapiSkin Application Started Successfully ....|");
		System.out.println(" |..................................................| \n\n");
		
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
          //  roleRepository.deleteAll();
			Role adminRole = new Role(RoleName.ROLE_ADMIN);
			Role useRole = new Role(RoleName.ROLE_USER);
			roleRepository.save(adminRole);
			roleRepository.save(useRole);
		};
	}

}
