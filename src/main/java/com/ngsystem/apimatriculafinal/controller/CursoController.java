package com.ngsystem.apimatriculafinal.controller;


import com.ngsystem.apimatriculafinal.dto.CursoDTO;
import com.ngsystem.apimatriculafinal.model.Curso;
import com.ngsystem.apimatriculafinal.service.ICursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    //@Autowired
    private final ICursoService service;

    @Qualifier("cursoMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>>  readAll() throws Exception{
        List<CursoDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Curso obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> create(@Valid @RequestBody CursoDTO dto) throws Exception {
        Curso obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CursoDTO dto) throws Exception {
        dto.setIdCurso(id);
        Curso obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CursoDTO convertToDto(Curso obj){
        return mapper.map(obj, CursoDTO.class);
    }

    private Curso convertToEntity(CursoDTO dto){
        return mapper.map(dto, Curso.class);
    }
}
