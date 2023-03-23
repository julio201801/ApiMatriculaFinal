package com.ngsystem.apimatriculafinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ngsystem.apimatriculafinal.model.Estudiante;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {
    @Min(value = 1)
    private Integer idMatricula;
    @NotNull
    private LocalDateTime fechaMatricula;
    @NotNull
    private Estudiante estudiante;
    @NotNull
    @JsonManagedReference
    private List<DetalleMatriculaDTO> details;
}
