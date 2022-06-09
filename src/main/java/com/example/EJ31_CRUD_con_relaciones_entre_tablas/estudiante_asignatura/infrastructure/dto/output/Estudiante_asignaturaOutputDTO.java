package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.dto.output;

import lombok.Data;

import java.sql.Date;

@Data
public class Estudiante_asignaturaOutputDTO {

    private String id_asigantura;
    private String id_estudiante;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;
}