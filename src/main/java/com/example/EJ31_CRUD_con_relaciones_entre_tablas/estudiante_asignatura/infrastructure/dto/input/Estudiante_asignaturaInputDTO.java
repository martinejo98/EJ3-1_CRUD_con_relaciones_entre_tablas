package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.dto.input;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain.Estudiante_asignatura;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Estudiante_asignaturaInputDTO {

    private List<String> student;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;

}
