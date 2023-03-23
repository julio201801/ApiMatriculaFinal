package com.ngsystem.apimatriculafinal.service.impl;

import com.ngsystem.apimatriculafinal.dto.EstudianteDTO;
import com.ngsystem.apimatriculafinal.model.Estudiante;
import com.ngsystem.apimatriculafinal.repo.IEstudianteRepo;
import com.ngsystem.apimatriculafinal.repo.IGenericRepo;
import com.ngsystem.apimatriculafinal.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparingInt;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante,Integer> implements IEstudianteService {
    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> orderestidianteDesc() {

        return repo.findAll()
                .stream()
                .sorted(comparingInt(Estudiante::getEdad).reversed())
                .toList();

    }
}
