package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.controller;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.application.EstudianteService;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.application.PersonaService;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.input.EstudianteInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.output.EstudianteOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    PersonaService personaService;

    @PostMapping("/addEstudiante")
    public EstudianteOutputDTO addEstudiante(@RequestBody @Valid EstudianteInputDTO estudianteInputDTO){
        return estudianteService.addEstudiante(estudianteInputDTO);
    }

    @GetMapping("/getEstudiante/{id}")
    public EstudianteOutputDTO getEstudiante(@RequestParam(value = "outputType", required = false, defaultValue = "simple") String outputType, @PathVariable String id){
        //le pregutno si la varbal outoputtype puede estar o no
        if(outputType.equals("full")){
            return estudianteService.getEstudianteFull(id);
        }else{
            return estudianteService.getEstudiante(id);
        }
    }

    @PutMapping("/update/{id}")
    public void updateEstudiante(@RequestBody EstudianteInputDTO estudianteInputDTO, @PathVariable String id){
        estudianteService.updateEstudiante(id, estudianteInputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEstudiante(@PathVariable String id){
        estudianteService.deleteEstudiante(id);
        return "Estudiante eliminado";
    }
}
