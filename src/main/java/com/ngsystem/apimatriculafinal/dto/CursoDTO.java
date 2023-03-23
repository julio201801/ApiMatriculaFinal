package com.ngsystem.apimatriculafinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {
    @Min(value = 1)
    private Integer idCurso;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nombreCurso;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String siglasCurso;
    @NotNull

    private boolean estadoCurso;
}
