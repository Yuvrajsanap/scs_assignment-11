package com.example.securityapp;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// Check if roles already exist before creating them
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			Role adminRole = new Role();
			adminRole.setName("ROLE_ADMIN");
			roleRepository.save(adminRole);
		}

		if (roleRepository.findByName("ROLE_USER") == null) {
			Role userRole = new Role();
			userRole.setName("ROLE_USER");
			roleRepository.save(userRole);
		}

		// Create admin user if not already present
		if (userRepository.findByUsername("admin") == null) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin123"));
			admin.setEnabled(true);
			admin.setRoles(new HashSet<>(roleRepository.findAll()));
			userRepository.save(admin);
		}

		// Create regular user if not already present
		if (userRepository.findByUsername("user") == null) {
			User user = new User();
			user.setUsername("user");
			user.setPassword(passwordEncoder.encode("user123"));
			user.setEnabled(true);
			user.setRoles(new HashSet<>(roleRepository.findByName("ROLE_USER")));
			userRepository.save(user);
		}
	}
}
