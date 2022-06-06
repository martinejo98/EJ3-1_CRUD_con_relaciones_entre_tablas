package com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    int id_persona;

    @Column
    @NotBlank(message = "No puede estar vacio")
    @Size(min = 6, max = 10)
    private String usuario;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String password;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String name;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String surname;

    @Column
    @NotBlank(message = "No puede estar vacio")
    @Email
    private String company_email;

    @Column
    @NotBlank(message = "No puede estar vacio")
    @Email
    private String personal_email;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String city;

    @Column
    @NotNull
    private Boolean active;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String created_date;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String imagen_url;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String termination_date;
}
