package com.sistema.SistemaBiblioteca.controller;

import com.sistema.SistemaBiblioteca.dto.request.LibroRequestDto;
import com.sistema.SistemaBiblioteca.dto.response.AgregarLibroResponseDto;
import com.sistema.SistemaBiblioteca.dto.response.BuscarLibrosResponseDto;
import com.sistema.SistemaBiblioteca.model.Libro;
import com.sistema.SistemaBiblioteca.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/libro")
public class LibroController {

    private final LibroService libroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Libro>> listarLibros(){

        return ResponseEntity.ok(libroService.findAll());

    }

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
//        primera forma
//        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
//        segunda forma
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
