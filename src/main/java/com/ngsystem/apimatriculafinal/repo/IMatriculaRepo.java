package com.ngsystem.apimatriculafinal.repo;

import com.ngsystem.apimatriculafinal.model.Estudiante;
import com.ngsystem.apimatriculafinal.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculaRepo extends IGenericRepo<Matricula, Integer> {
}
