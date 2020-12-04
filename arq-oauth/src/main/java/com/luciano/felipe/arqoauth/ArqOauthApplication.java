package com.luciano.felipe.arqoauth;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.luciano.felipe.arqoauth.entities.Permission;
import com.luciano.felipe.arqoauth.entities.User;
import com.luciano.felipe.arqoauth.repository.PermissionRepository;
import com.luciano.felipe.arqoauth.repository.UserRepository;



@SpringBootApplication
public class ArqOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqOauthApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, PermissionRepository permissionRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		return args -> {
			initUsers(userRepository,permissionRepository,bCryptPasswordEncoder);
		};

	}

	private void initUsers(UserRepository userRepository, PermissionRepository permissionRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		Permission permission=null;
		Permission finPermission = permissionRepository.findByDescription("Admin");
		if(finPermission==null) {
			permission = new Permission();
			permission.setDescription("Admin");
			permission = permissionRepository.save(permission);
		}else {
			permission = finPermission;
		}
		
		User admin = new User();
		admin.setUserName("luciano");
		admin.setAccountNonExpired(true);
		admin.setAccountNonLocked(true);
		admin.setCredentialsNonExpired(true);
		admin.setEnabled(true);
		admin.setPassword(bCryptPasswordEncoder.encode("123456"));
		admin.setPermissions(Arrays.asList(permission));
		
		User find = userRepository.findByUsername("luciano");
		if(find==null) {
			userRepository.save(admin);
		}
	}

}
