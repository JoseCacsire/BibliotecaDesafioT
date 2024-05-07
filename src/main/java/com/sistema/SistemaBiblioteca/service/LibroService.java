package com.sistema.SistemaBiblioteca.service;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.dto.response.AgregarLibroResponseDto;
import com.sistema.SistemaBiblioteca.dto.response.BuscarLibrosResponseDto;

import java.util.List;

public interface LibroService {
    AgregarLibroResponseDto agregarLibro(LibroRequestDto requestDto);


    List<BuscarLibrosResponseDto> buscarLibroPorCriterio(String titulo, String autor, String genero);
}
