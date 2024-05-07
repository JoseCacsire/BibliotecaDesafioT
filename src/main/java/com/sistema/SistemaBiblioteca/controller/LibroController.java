package com.sistema.SistemaBiblioteca.controller;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.dto.response.AgregarLibroResponseDto;
import com.sistema.SistemaBiblioteca.dto.response.BuscarLibrosResponseDto;
import com.sistema.SistemaBiblioteca.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarLibro(@RequestParam(required = false) String titulo,
                                         @RequestParam(required = false) String autor,
                                         @RequestParam(required = false) String genero) {

        List<BuscarLibrosResponseDto> libros = libroService.buscarLibroPorCriterio(titulo, autor, genero);
        if (libros.isEmpty()) {
            String mensaje;
            if (titulo != null && !titulo.isEmpty()) {
                mensaje = "Libro '" + titulo + "' no encontrado en la base de datos.";
            } else if (autor != null && !autor.isEmpty()) {
                mensaje = "No se encontraron libros del autor '" + autor + "'.";
            } else if (genero != null && !genero.isEmpty()) {
                mensaje = "No se encontraron libros del género '" + genero + "'.";
            } else {
                mensaje = "Debe proporcionar al menos un criterio de búsqueda.";
                return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }



    @PostMapping("/agregar")
    public ResponseEntity<AgregarLibroResponseDto> agregarLibro(@RequestBody LibroRequestDto requestDto) {
        AgregarLibroResponseDto responseDto = libroService.agregarLibro(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
