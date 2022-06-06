package com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PersonaOutputDTO {

    private int id_persona;
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String city;
    private Boolean active;
    private String created_date;
    private String imagen_url;
    private String termination_date;
}
