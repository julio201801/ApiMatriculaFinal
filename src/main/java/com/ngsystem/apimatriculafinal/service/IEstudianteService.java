package com.ngsystem.apimatriculafinal.service;


import com.ngsystem.apimatriculafinal.dto.EstudianteDTO;
import com.ngsystem.apimatriculafinal.model.Estudiante;

import java.util.List;


public interface IEstudianteService extends ICRUD<Estudiante, Integer>{
    List<Estudiante> orderestidianteDesc();

}

