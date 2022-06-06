package com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.controller;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.application.service.ProfesorService;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.exception.UnprocesableException;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.input.ProfesorInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.output.ProfesorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/addProfesor")
    public String addProfesor(@RequestBody @Valid ProfesorInputDTO profesorInputDTO) throws Exception {            //@valid valida que lso datos que le paso sean correctos.
        profesorService.addProfesor(profesorInputDTO);
        return "Persona añadida";
    }

    @GetMapping("/getProfesor/{id}")
    public ProfesorOutputDTO getProfesor(@PathVariable String id) {
        return profesorService.getProfesor(id);
    }

    @PutMapping("/update/{id}")
    public String updateProfesor(@RequestBody @Valid ProfesorInputDTO profesor, @PathVariable String id) throws UnprocesableException {
        profesorService.updateProfesor(profesor, id);
        return "Profesor actualziado";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfesor(@PathVariable String id) {
        profesorService.deleteProfesor(id);
        return "Profesor eliminado";
    }
}
