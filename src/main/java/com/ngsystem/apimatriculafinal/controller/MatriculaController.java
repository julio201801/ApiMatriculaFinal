package com.ngsystem.apimatriculafinal.controller;


import com.ngsystem.apimatriculafinal.dto.MatriculaDTO;
import com.ngsystem.apimatriculafinal.dto.ResultDTO;
import com.ngsystem.apimatriculafinal.model.Matricula;
import com.ngsystem.apimatriculafinal.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    //@Autowired
    private final IMatriculaService service;

    @Qualifier("matriculaMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>>  readAll() throws Exception{
        List<MatriculaDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/cursoporestudiante")
    public ResponseEntity<List<ResultDTO>> getCursoEstudiante(){
        List<ResultDTO> olista = service.cursoEstudiante();
        return new ResponseEntity<>(olista, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Matricula obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> create(@Valid @RequestBody MatriculaDTO dto) throws Exception {
        Matricula obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MatriculaDTO dto) throws Exception {
        dto.setIdMatricula(id);
        Matricula obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private MatriculaDTO convertToDto(Matricula obj){
        return mapper.map(obj, MatriculaDTO.class);
    }

    private Matricula convertToEntity(MatriculaDTO dto){
        return mapper.map(dto, Matricula.class);
    }
}
