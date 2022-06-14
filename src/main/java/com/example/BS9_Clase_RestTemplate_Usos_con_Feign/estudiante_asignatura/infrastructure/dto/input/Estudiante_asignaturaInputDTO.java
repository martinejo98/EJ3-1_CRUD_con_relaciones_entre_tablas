package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante_asignatura.infrastructure.dto.input;

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
