    package com.sistema.SistemaBiblioteca.model;

    import jakarta.persistence.*;
    import lombok.*;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    @Table(name = "Libros")
    public class Libro {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "libro_id")
        private Long id;
        private String titulo;
        private String autor;
        private String genero;
        private Integer anoPublicacion;

        @Override
        public String toString() {
            return "Libro{" +
                    "id=" + id +
                    ", titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", genero='" + genero + '\'' +
                    ", anoPublicacion=" + anoPublicacion +
                    '}';
        }
    }
