package com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.input;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Estudiante_asignatura;
import lombok.Data;

import java.util.List;

@Data
public class EstudianteInputDTO {

    private int persona;
    private Integer num_hours_week;
    private String coments;
    private int profesor;
    private String branch;
    private List<Estudiante_asignatura> estudios;

}
