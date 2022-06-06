package com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.controller;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.application.service.EstudianteService;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.application.service.PersonaService;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.input.EstudianteInputDTO;
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
    public EstudianteInputDTO addEstudiante(@RequestBody @Valid EstudianteInputDTO estudianteInputDTO){
        estudianteService.addEstudiante(estudianteInputDTO);
        return estudianteInputDTO;
    }

    @GetMapping("/getEstudiante/{id}")
    public Object getEstudiante(@RequestParam(value = "outputType", required = false, defaultValue = "simple") String outputType, @PathVariable int id){
        //le pregutno si la varbal outoputtype puede estar o no
        if(outputType.equals("full")){
            return personaService.getPersonaByID(id)+" "+estudianteService.getEstudiante(id);
        }else{
            return estudianteService.getEstudiante(id);
        }
    }

    @PutMapping("/update/{id}")
    public void updateEstudiante(@RequestBody EstudianteInputDTO estudianteInputDTO, @PathVariable int id){
        estudianteService.updateEstudiante(id, estudianteInputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEstudiante(@PathVariable int id){
        estudianteService.deleteEstudiante(id);
        return "Estudiante eliminado";
    }
}
