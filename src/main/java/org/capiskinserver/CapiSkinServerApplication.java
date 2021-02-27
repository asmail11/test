package org.capiskinserver;


import org.capiskinserver.security.service.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@ComponentScan({"org.capiskinserver.application.hair.service**"})
@ContextConfiguration(classes = {WebSecurityConfig.class})
public class CapiSkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapiSkinServerApplication.class, args);
		
		System.out.println("\n\n |..................................................|");
		System.out.println(" |... CapiSkin Application Started Successfully ....|");
		System.out.println(" |..................................................| \n\n");
		

	}

}
