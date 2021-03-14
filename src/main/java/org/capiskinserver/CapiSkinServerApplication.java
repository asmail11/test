package org.capiskinserver;

import org.capiskinserver.security.model.Role;
import org.capiskinserver.security.model.ERole;
import org.capiskinserver.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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
            if (roleRepository.findAll().size() == 0) {
    			Role adminRole = new Role(ERole.ROLE_ADMIN);
    			Role useRole = new Role(ERole.ROLE_USER);
    			Role lomRole = new Role(ERole.ROLE_LABORATORY);
    		    roleRepository.save(adminRole);
    		    roleRepository.save(useRole);	
    		    roleRepository.save(lomRole);
			}
		};
	}
	

}
