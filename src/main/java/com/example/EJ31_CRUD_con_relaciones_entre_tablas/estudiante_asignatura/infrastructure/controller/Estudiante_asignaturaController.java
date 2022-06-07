package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.controller;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.input.EstudianteInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.output.EstudianteOutputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.application.Estudiante_asignaturaService;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain.Estudiante_asignatura;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.dto.input.Estudiante_asignaturaInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.dto.output.Estudiante_asignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/asignatura")
public class Estudiante_asignaturaController {

    @Autowired
    Estudiante_asignaturaService estudiante_asignaturaService;

    @PostMapping("/addEstudiante")
    public Estudiante_asignaturaOutputDTO addAsignatura(@RequestBody @Valid Estudiante_asignaturaInputDTO estudiante_asignaturaInputDTO){
        return estudiante_asignaturaService.addAsignatura(estudiante_asignaturaInputDTO);
    }

    @GetMapping("/getAsignatura/{id}")
    public Estudiante_asignaturaOutputDTO getAsignatura(@PathVariable String id){
        return estudiante_asignaturaService.getAsignatura(id);
    }

    @PutMapping("/update/{id}")
    public void updateAsignatura(@RequestBody Estudiante_asignaturaInputDTO estudiante_asignaturaInputDTO, @PathVariable String id){
        estudiante_asignaturaService.updateAsignatura(id, estudiante_asignaturaInputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAsignatura(@PathVariable String id){
        estudiante_asignaturaService.deleteAsignatura(id);
        return "Estudiante eliminado";
    }
}
