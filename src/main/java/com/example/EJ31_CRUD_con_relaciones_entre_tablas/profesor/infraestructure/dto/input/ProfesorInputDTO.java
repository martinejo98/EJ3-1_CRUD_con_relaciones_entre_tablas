package com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.dto.input;

import lombok.Data;

@Data
public class ProfesorInputDTO {

    private String id_profesor;
    private String id_persona;
    private String coments;
    private String branch;
}
