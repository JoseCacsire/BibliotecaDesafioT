package com.sistema.SistemaBiblioteca.service;

import com.sistema.SistemaBiblioteca.dto.request.PrestamoRequestDto;
import com.sistema.SistemaBiblioteca.model.Libro;
import com.sistema.SistemaBiblioteca.model.Prestamo;
import com.sistema.SistemaBiblioteca.repository.LibroRepository;
import com.sistema.SistemaBiblioteca.repository.PrestamoRepository;
import com.sistema.SistemaBiblioteca.service.impl.PrestamoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class PrestamoServiceTest {

    @Mock//simulado del repositorio
    private PrestamoRepository prestamoRepository;

    @Mock//simulado del repositorio
    private LibroRepository libroRepository;

    @InjectMocks//inyectando los mocks en la clase
    private PrestamoServiceImpl prestamoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Test para prestar un libro")
    @Test
    void prestarLibro() throws ParseException {

        // Arrange
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPrestamo = dateFormat.parse("2024-05-03");
        Date fechaDevolucionPrevista = dateFormat.parse("2024-05-10");

        PrestamoRequestDto requestDto = new PrestamoRequestDto();
        requestDto.setTitulo("El nombre del libro");
        requestDto.setFechaPrestamo(fechaPrestamo);
        requestDto.setFechaDevolucionPrevista(fechaDevolucionPrevista);


        Libro libro = new Libro();
        libro.setId(1L);
        libro.setTitulo("El nombre del libro");

        when(libroRepository.findByTitulo(anyString())).thenReturn(Optional.of(libro));

        // Act
        prestamoService.prestarLibro(requestDto);



        // Assert
        verify(libroRepository, times(1)).findByTitulo(anyString());
        verify(prestamoRepository, times(1)).save(any(Prestamo.class));
    }
}