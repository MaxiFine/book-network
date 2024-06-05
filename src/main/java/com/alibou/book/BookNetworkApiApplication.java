package com.alibou.book;

import com.alibou.book.auth.AuthenticationService;
import com.alibou.book.auth.RegistrationRequest;

import com.alibou.book.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import static com.alibou.book.role.Role.*;
import static com.alibou.book.roleperms.Role.ADMIN;

@SpringBootApplication
// the attribute tells what kind of method to refer for auditing purposes
@EnableJpaAuditing(auditorAwareRef = "auditorAware") // when you use the EntityListeners
@EnableAsync
public class BookNetworkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookNetworkApiApplication.class, args);
	}

	@Bean  // to insert a role when new user is created
	public CommandLineRunner runner(RoleRepository roleRepository){
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()){
				roleRepository.save(
						builder().name("USER").build()
						);
			}
		};
	}

//	@Bean
//	public CommandLineRunner addAdmin(AuthenticationService authService){
//		return args-> {
//			var admin = RegistrationRequest.builder()
//					.firstname("Max")
//					.lastname("Well")
//					.email("gibboel5@gmail.com")
//					.password("maxwell22")
//					.role(ADMIN)
//					.build();
//			//System.out.println("Admin Token is: ", authService.register(admin));
//		};
//
//	}
}
