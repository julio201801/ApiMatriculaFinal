package com.ngsystem.apimatriculafinal.controller;


import com.ngsystem.apimatriculafinal.dto.EstudianteDTO;
import com.ngsystem.apimatriculafinal.model.Estudiante;
import com.ngsystem.apimatriculafinal.service.IEstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    //@Autowired
    private final IEstudianteService service;

    @Qualifier("estudianteMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>>  readAll() throws Exception{
        List<EstudianteDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/orderStudentDesc")
    public ResponseEntity<List<EstudianteDTO>>  orderStudentDesc() throws Exception{
       List<EstudianteDTO> list = service.orderestidianteDesc().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Estudiante obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EstudianteDTO> create(@Valid @RequestBody EstudianteDTO dto) throws Exception {
        Estudiante obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody EstudianteDTO dto) throws Exception {
        dto.setIdEstudiante(id);
        Estudiante obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private EstudianteDTO convertToDto(Estudiante obj){
        return mapper.map(obj, EstudianteDTO.class);
    }

    private Estudiante convertToEntity(EstudianteDTO dto){
        return mapper.map(dto, Estudiante.class);
    }
}
