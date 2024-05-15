package com.sistema.SistemaBiblioteca.service.impl;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.dto.response.AgregarLibroResponseDto;
import com.sistema.SistemaBiblioteca.dto.response.BuscarLibrosResponseDto;
import com.sistema.SistemaBiblioteca.mapper.LibroMapper;
import com.sistema.SistemaBiblioteca.model.Libro;
import com.sistema.SistemaBiblioteca.repository.LibroRepository;
import com.sistema.SistemaBiblioteca.service.LibroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@RequiredArgsConstructor
@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    @Override
    @Transactional
    public AgregarLibroResponseDto agregarLibro(LibroRequestDto requestDto) {

//        Esto usalo sino usas mapper

//        Libro nuevoLibro = Libro.builder()
//                .titulo(requestDto.getTitulo())
//                .autor(requestDto.getAutor())
//                .genero(requestDto.getGenero())
//                .anoPublicacion(requestDto.getAnoPublicacion())
//                .build();
//      return new AgregarLibroResponseDto(libroGuardado);

//      Usando mapper
        Libro nuevoLibro = libroMapper.toLibro(requestDto);

        Libro libroGuardado = libroRepository.save(nuevoLibro);
        log.error(String.valueOf(libroGuardado.getId()));
        return libroMapper.toLibroResponseDto(libroGuardado);
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

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }


}
