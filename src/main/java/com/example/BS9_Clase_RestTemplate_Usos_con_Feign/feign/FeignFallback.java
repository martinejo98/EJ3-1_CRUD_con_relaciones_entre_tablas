package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.feign;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.controller.ProfesorController;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements IFeignServer{

    @Autowired
    ProfesorController profesorController;

    @Override
    public ResponseEntity<ProfesorOutputDTO> getProfesorFeign(String id) {
        return ResponseEntity.ok(profesorController.getProfesor(id));
    }
}
