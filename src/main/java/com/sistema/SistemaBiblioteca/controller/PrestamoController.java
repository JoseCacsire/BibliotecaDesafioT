package com.sistema.SistemaBiblioteca.controller;

import com.sistema.SistemaBiblioteca.dto.request.PrestamoRequestDto;
import com.sistema.SistemaBiblioteca.service.PrestamoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prestamo")
public class PrestamoController {

    private final PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<String> prestarLibro(@RequestBody PrestamoRequestDto prestamoRequestDto){

        try {
            prestamoService.prestarLibro(prestamoRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Libro prestado exitosamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al prestar libro");
        }


    }

}
