package com.sistema.SistemaBiblioteca.service;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.dto.response.AgregarLibroResponseDto;
import com.sistema.SistemaBiblioteca.model.Libro;
import com.sistema.SistemaBiblioteca.repository.LibroRepository;
import com.sistema.SistemaBiblioteca.service.impl.LibroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LibroServiceTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;


    @DisplayName("Test para guardar un libro")
    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

    }

    @DisplayName("Test para agregar un libro")
    @Test
    void testAgregarLibro() {
        LibroRequestDto requestDto = new LibroRequestDto();
        requestDto.setTitulo("Prueba");
        requestDto.setAutor("Autor");
        requestDto.setGenero("Genero");
        requestDto.setAnoPublicacion(2024);

        Libro libroGuardado = new Libro();
        libroGuardado.setId(1L);
        libroGuardado.setTitulo("Prueba1");
        libroGuardado.setAutor("Autor");
        libroGuardado.setGenero("Genero");
        libroGuardado.setAnoPublicacion(2024);

        when(libroRepository.save(any(Libro.class))).thenReturn(libroGuardado);

        AgregarLibroResponseDto responseDto = libroService.agregarLibro(requestDto);

        assertEquals(libroGuardado.getId(), responseDto.getId());
        assertEquals(libroGuardado.getTitulo(), responseDto.getTitulo());
        assertEquals(libroGuardado.getAutor(), responseDto.getAutor());
        assertEquals(libroGuardado.getGenero(), responseDto.getGenero());
        assertEquals(libroGuardado.getAnoPublicacion(), responseDto.getAnoPublicacion());


//        No necesito poner el tostring ya q ya lo especifice en La clase Libro
        System.out.println("Libro guardado: "+libroGuardado);
    }


}