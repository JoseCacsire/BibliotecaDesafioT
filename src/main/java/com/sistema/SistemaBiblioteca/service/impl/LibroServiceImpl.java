package com.sistema.SistemaBiblioteca.service.impl;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.dto.response.AgregarLibroResponseDto;
import com.sistema.SistemaBiblioteca.dto.response.BuscarLibrosResponseDto;
import com.sistema.SistemaBiblioteca.model.Libro;
import com.sistema.SistemaBiblioteca.repository.LibroRepository;
import com.sistema.SistemaBiblioteca.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    @Override
    @Transactional
    public AgregarLibroResponseDto agregarLibro(LibroRequestDto requestDto) {

        Libro nuevoLibro = Libro.builder()
                .titulo(requestDto.getTitulo())
                .autor(requestDto.getAutor())
                .genero(requestDto.getGenero())
                .anoPublicacion(requestDto.getAnoPublicacion())
                .build();

        Libro libroGuardado = libroRepository.save(nuevoLibro);

        return new AgregarLibroResponseDto(libroGuardado);
    }

    @Override
    public List<BuscarLibrosResponseDto> buscarLibroPorCriterio(String titulo, String autor, String genero) {
        List<Libro> librosEncontrados = new ArrayList<>();
            if (titulo != null && !titulo.isEmpty()) {
                librosEncontrados = libroRepository.findByTituloContainingIgnoreCase(titulo);
            } else if (autor != null && !autor.isEmpty()) {
                librosEncontrados = libroRepository.findByAutorContainingIgnoreCase(autor);
            } else if (genero != null && !genero.isEmpty()) {
                librosEncontrados = libroRepository.findByGeneroContainingIgnoreCase(genero);
            }

        return librosEncontrados.stream().map(BuscarLibrosResponseDto::new).collect(Collectors.toList());

    }


}
