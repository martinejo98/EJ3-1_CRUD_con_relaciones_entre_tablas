package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.dto.input;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain.Estudiante_asignatura;
import lombok.Data;

import java.sql.Date;

@Data
public class Estudiante_asignaturaInputDTO {

    private String id_estudiante;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;

    public Estudiante_asignaturaInputDTO(Estudiante_asignatura estudiante_asignatura){
        setId_estudiante(estudiante_asignatura.getStudent().getId_student());
        setAsignatura(estudiante_asignatura.getAsignatura());
        setComents(estudiante_asignatura.getComment());
        setInitial_date(estudiante_asignatura.getInitial_date());
        setFinish_date(estudiante_asignatura.getInitial_date());
    }
}
