package com.sistema.SistemaBiblioteca.service;

import com.sistema.SistemaBiblioteca.dto.request.PrestamoRequestDto;

public interface PrestamoService {

    void prestarLibro(PrestamoRequestDto prestamoRequestDto);
}
