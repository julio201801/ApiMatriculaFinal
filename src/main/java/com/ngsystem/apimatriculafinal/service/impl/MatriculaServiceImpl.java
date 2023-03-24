package com.ngsystem.apimatriculafinal.service.impl;

import com.ngsystem.apimatriculafinal.dto.ResultDTO;
import com.ngsystem.apimatriculafinal.model.Curso;
import com.ngsystem.apimatriculafinal.model.DetalleMatricula;
import com.ngsystem.apimatriculafinal.model.Estudiante;
import com.ngsystem.apimatriculafinal.model.Matricula;
import com.ngsystem.apimatriculafinal.repo.IMatriculaRepo;
import com.ngsystem.apimatriculafinal.repo.IGenericRepo;
import com.ngsystem.apimatriculafinal.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.reader.StreamReader;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {
    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<ResultDTO> cursoEstudiante() {
        //grupo de estudiantes matriculados
        var objlista = new ArrayList<ResultDTO>();

        Map<Integer,Map<String,Long>> porEstudiante= repo.findAll()
                .stream()
                .collect(groupingBy(d->d.getIdMatricula(),Collectors.groupingBy(d->d.getEstudiante().getNombres(),counting())));
        /////////////////////////////////////////////////////////////
        Stream<List<DetalleMatricula>> stream = repo.findAll().stream().map(Matricula::getDetails);
        //grupo cursos matriculados
        Stream<DetalleMatricula> streamDetailMatricula = stream.flatMap(Collection::stream);
        //System.out.println(streamDetail);
        Map<Integer, Map<String,Long>> porCursos = streamDetailMatricula
                .collect(groupingBy(d->d.getMatricula().getIdMatricula(),Collectors.groupingBy(d->d.getCurso().getNombre(),counting())));
        //imprimindo los estudiantes matriculados
        Stream<Map<Integer, Map<String,Long>>> cursoStream = Stream.of(porCursos);
        Stream<Map<Integer, Map<String,Long>>> estudianteStream = Stream.of(porEstudiante);
        //Stream<Map<Integer, Map<String,Long>>> resultadoStream = Stream.concat(cursoStream, estudianteStream);
        //System.out.println(resultadoStream.collect(Collectors.toList()));
        //resultadoStream.forEach(k,v);
        // convert stream to string
        porCursos.forEach((k,v)->{
            Integer id = k.intValue();
            String curso = v.keySet().toString().replace("[","").replace("]","");
            var resultado= new ResultDTO();
            //System.out.println(id);
            System.out.println(curso);
            //System.out.println(porEstudiante.entrySet().stream().filter(e->e.getKey().equals(id)).toString());
            Map<Integer, Map<String,Long>> result = porEstudiante.entrySet()
                    .stream()
                    .filter(map -> map.getKey().equals(id))
                    .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

            System.out.println(result.toString().substring(4,10).replace("=",""));
            resultado.setCursos(curso);
            resultado.setAlumno(result.toString().substring(4,10).replace("=",""));
            objlista.add(resultado);
            curso="";
        });

    return objlista;
    }
}
