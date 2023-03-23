package com.ngsystem.apimatriculafinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    @Column(nullable = false, length = 50)

    private String nombres;
    @Column(nullable = false, length = 50)

    private String apellidos;
    @Column(nullable = false, length = 8)
    private String dni;
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Integer edad;
}
