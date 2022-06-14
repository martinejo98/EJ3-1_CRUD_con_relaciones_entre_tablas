package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.controller;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.application.ProfesorService;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.exception.UnprocesableException;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.input.ProfesorInputDTO;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/addProfesor")
    public ProfesorOutputDTO addProfesor(@RequestBody @Valid ProfesorInputDTO profesorInputDTO) throws Exception {            //@valid valida que lso datos que le paso sean correctos.
        return profesorService.addProfesor(profesorInputDTO);
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
