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

//    Esta relación es útil si tu sistema generalmente presta un solo libro a la vez por cada préstamo.
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
