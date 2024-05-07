package com.sistema.SistemaBiblioteca;

import com.sistema.SistemaBiblioteca.model.Libro;
import com.sistema.SistemaBiblioteca.model.Role;
import com.sistema.SistemaBiblioteca.model.RoleEntity;
import com.sistema.SistemaBiblioteca.model.UserEntity;
import com.sistema.SistemaBiblioteca.repository.LibroRepository;
import com.sistema.SistemaBiblioteca.repository.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SistemaDeBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeBibliotecaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserEntityRepository userEntityRepository, LibroRepository libroRepository, PasswordEncoder passwordEncoder){
		return args -> {

//			Create books
			Libro libro1 = Libro.builder()
					.titulo("Los rios profundos")
					.autor("Jose Maria Arguedas")
					.genero("Novela")
					.anoPublicacion(1958)
					.build();

			Libro libro2 = Libro.builder()
					.titulo("La ciudad y los perros")
					.autor("Mario Vargas Llosa")
					.genero("Novela")
					.anoPublicacion(1963)
					.build();

			Libro libro3 = Libro.builder()
					.titulo("Don Quijote de la Mancha")
					.autor("Miguel de Cervantes")
					.genero("Novela")
					.anoPublicacion(1605)
					.build();

//          Create users
			UserEntity userEntity = UserEntity.builder()
					.email("jose@gmail.com")
					.username("jose")
					.password(passwordEncoder.encode("jose"))
					.roles(Set.of(RoleEntity.builder()
							.name(Role.valueOf(Role.USER.name()))
							.build()))
					.build();

			userEntityRepository.save(userEntity);
			libroRepository.saveAll(List.of(libro1,libro2,libro3));
		};
	}

}
