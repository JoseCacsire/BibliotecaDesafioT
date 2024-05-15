package com.sistema.SistemaBiblioteca.dto.response;

import com.sistema.SistemaBiblioteca.model.Libro;
import lombok.Getter;
import lombok.Setter;

//Agregar las anotaciones @Getter y @Setter de Lombok a tu clase AgregarLibroResponseDto
// puede haber resuelto el problema al proporcionar los métodos getter y setter necesarios
// para que Spring pueda serializar y deserializar correctamente los objetos de esta clase
// al enviar y recibir respuestas HTTP.
@Getter
@Setter
public class AgregarLibroResponseDto {

    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private int anoPublicacion;

//    Si usas la libreria mapstruc o mapper no uses esto
//    public AgregarLibroResponseDto(Libro libroGuardado) {
//        this.id = libroGuardado.getId();
//        this.titulo = libroGuardado.getTitulo();
//        this.autor = libroGuardado.getAutor();
//        this.genero = libroGuardado.getGenero();
//        this.anoPublicacion = libroGuardado.getAnoPublicacion();
//
//    }
}
