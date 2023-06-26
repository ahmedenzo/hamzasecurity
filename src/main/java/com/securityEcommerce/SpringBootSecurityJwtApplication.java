package com.securityEcommerce;

import com.securityEcommerce.models.ERole;
import com.securityEcommerce.models.Role;
import com.securityEcommerce.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityJwtApplication  implements CommandLineRunner {
	private final RoleRepository roleRepository;

	public SpringBootSecurityJwtApplication(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}


	@Override
	public void run(String... args) {
		// Save enum values to the database
		for (ERole role : ERole.values()) {
			Role dbRole = new Role();
			dbRole.setName(role);
			roleRepository.save(dbRole);
		}
	}
}
