package com.ngsystem.apimatriculafinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Matricula {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;
    @Column(nullable = false)
    private LocalDateTime fechaMatricula;
    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name= "FK_Matricula_estudiante"))
    private Estudiante estudiante;
    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<DetalleMatricula> details;
}
