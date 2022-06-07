package com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.dto.input;

import lombok.Data;

@Data
public class PersonaInputDTO {

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private String created_date;
    private String imagen_url;
    private String termination_date;
}
