package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.input;

import lombok.Data;

@Data
public class EstudianteInputDTO {

    private String persona;
    private Integer num_hours_week;
    private String coments;
    //private int profesor;
    private String branch;
    //private List<Estudiante_asignatura> estudios;

}
