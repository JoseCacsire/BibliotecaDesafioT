package com.sistema.SistemaBiblioteca.dto.response;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.model.Libro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BuscarLibrosResponseDto {

    private String titulo;
    private String autor;
    private String genero;
    private int anoPublicacion;

    public BuscarLibrosResponseDto (Libro libro) {
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
        this.genero = libro.getGenero();
        this.anoPublicacion = libro.getAnoPublicacion();

    }
}
