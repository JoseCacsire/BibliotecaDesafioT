package com.sistema.SistemaBiblioteca.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PrestamoRequestDto {

    private String titulo;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaPrestamo;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaDevolucionPrevista;

}
