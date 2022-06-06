package com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.output;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Estudiante_asignatura;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Persona;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Profesor;
import lombok.Data;

import java.util.List;

@Data
public class EstudianteOutputDTOFull extends PersonaOutputDTO  {

    private Integer id_student;
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
    private Profesor profesor;
    private String branch;
    private List<Estudiante_asignatura> estudios;

}
