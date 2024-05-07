package com.sistema.SistemaBiblioteca.service.impl;

import com.sistema.SistemaBiblioteca.dto.request.PrestamoRequestDto;
import com.sistema.SistemaBiblioteca.model.Libro;
import com.sistema.SistemaBiblioteca.model.Prestamo;
import com.sistema.SistemaBiblioteca.repository.LibroRepository;
import com.sistema.SistemaBiblioteca.repository.PrestamoRepository;
import com.sistema.SistemaBiblioteca.service.PrestamoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;


    @Override
    @Transactional
    public void prestarLibro(PrestamoRequestDto prestamoRequestDto) {
        Libro libro = libroRepository.findByTitulo(prestamoRequestDto.getTitulo())
                .orElseThrow(() -> new EntityNotFoundException("Libro con nombre: "+prestamoRequestDto.getTitulo()+" no encontrado"));

        Prestamo prestamo = Prestamo.builder()
                .fechaPrestamo(prestamoRequestDto.getFechaPrestamo())
                .fechaDevolucionPrevista(prestamoRequestDto.getFechaDevolucionPrevista())
                .libro(libro)
                .build();

        prestamoRepository.save(prestamo);

    }

}



