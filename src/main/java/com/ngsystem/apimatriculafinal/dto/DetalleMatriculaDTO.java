package com.ngsystem.apimatriculafinal.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngsystem.apimatriculafinal.model.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {
    @JsonBackReference
    private MatriculaDTO matricula;
    @Min(value = 1)
    private Integer idDetalleMatricula;
    @NotNull
    private Curso curso;
    @NotNull
    private String aula;
}
