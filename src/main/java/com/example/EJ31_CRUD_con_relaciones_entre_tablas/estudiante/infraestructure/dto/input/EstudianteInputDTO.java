package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.input;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain.Estudiante_asignatura;
import lombok.Data;

import java.util.List;

@Data
public class EstudianteInputDTO {

    private String persona;
    private Integer num_hours_week;
    private String coments;
    private String profesor;
    private String branch;
    //private List<Estudiante_asignatura> estudios;

}
