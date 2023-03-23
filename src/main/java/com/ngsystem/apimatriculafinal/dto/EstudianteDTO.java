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
public class EstudianteDTO {
    @Min(value = 1)
    private Integer idEstudiante;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nombres;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String apellidos;
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    private String dni;
    @NotNull
    private Integer edad;
}
