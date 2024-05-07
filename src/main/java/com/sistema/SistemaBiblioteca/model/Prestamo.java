package com.sistema.SistemaBiblioteca.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestamo_id")
    private Long id;
    private Date fechaPrestamo;
    private Date fechaDevolucionPrevista;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
