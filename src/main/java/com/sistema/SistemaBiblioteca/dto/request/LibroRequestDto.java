package com.sistema.SistemaBiblioteca.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroRequestDto {

    private String titulo;
    private String autor;
    private String genero;
    private int anoPublicacion;

}
