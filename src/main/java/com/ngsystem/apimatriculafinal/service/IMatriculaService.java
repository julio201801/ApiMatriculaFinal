package com.ngsystem.apimatriculafinal.service;

import com.ngsystem.apimatriculafinal.dto.ResultDTO;
import com.ngsystem.apimatriculafinal.model.Estudiante;
import com.ngsystem.apimatriculafinal.model.Matricula;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface IMatriculaService extends ICRUD<Matricula,Integer>{
    List<ResultDTO>  cursoEstudiante();
}
