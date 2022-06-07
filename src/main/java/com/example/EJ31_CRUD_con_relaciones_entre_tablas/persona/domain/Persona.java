package com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.PersonaSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @GenericGenerator(
        name = "idGenerator",
        strategy = "com.example.EJ31_CRUD_con_relaciones_entre_tablas.PersonaSequenceIdGenerator",
        parameters = {
            @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PER"),
            @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
        }
    )
    private String id_persona;

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
