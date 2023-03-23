package com.ngsystem.apimatriculafinal.service.impl;

import com.ngsystem.apimatriculafinal.model.Curso;
import com.ngsystem.apimatriculafinal.model.Estudiante;
import com.ngsystem.apimatriculafinal.repo.ICursoRepo;
import com.ngsystem.apimatriculafinal.repo.IEstudianteRepo;
import com.ngsystem.apimatriculafinal.repo.IGenericRepo;
import com.ngsystem.apimatriculafinal.service.ICursoService;
import com.ngsystem.apimatriculafinal.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso,Integer> implements ICursoService {
    private final ICursoRepo repo;
    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {

        return  repo;
    }
}
