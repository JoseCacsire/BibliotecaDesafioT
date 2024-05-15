package com.sistema.SistemaBiblioteca.repository;

import com.sistema.SistemaBiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {



    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAutorContainingIgnoreCase(String autor);
    List<Libro> findByGeneroContainingIgnoreCase(String genero);
    Optional<Libro> findByTitulo(String titulo);
}
