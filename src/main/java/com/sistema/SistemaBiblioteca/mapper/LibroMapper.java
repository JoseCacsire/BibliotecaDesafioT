package com.sistema.SistemaBiblioteca.mapper;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.dto.response.AgregarLibroResponseDto;
import com.sistema.SistemaBiblioteca.model.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroMapper {


    LibroMapper  instance = Mappers.getMapper(LibroMapper.class);

    @Mapping(target = "id", ignore = true) // Ignorar el campo 'id' al mapear desde el DTO
    Libro toLibro(LibroRequestDto libroRequestDto);

    AgregarLibroResponseDto toLibroResponseDto(Libro libro);
}
