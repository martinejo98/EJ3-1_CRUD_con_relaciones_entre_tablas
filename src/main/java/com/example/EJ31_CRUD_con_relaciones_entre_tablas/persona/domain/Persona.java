package com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.PersonaSequenceIdGenerator;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.dto.input.PersonaInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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

    @OneToOne(mappedBy = "persona")
    private Estudiante estudiante;

    @OneToOne(mappedBy = "persona")
    private Profesor profesor;

    public Persona (PersonaInputDTO personaInputDTO){
        setUsuario(personaInputDTO.getUsuario());
        setName(personaInputDTO.getName());
        setSurname(personaInputDTO.getSurname());
        setCompany_email(personaInputDTO.getCompany_email());
        setPersonal_email(personaInputDTO.getPersonal_email());
        setCity(personaInputDTO.getCity());
        setActive(personaInputDTO.getActive());
        setCreated_date(personaInputDTO.getCreated_date());
        setImagen_url(personaInputDTO.getImagen_url());
        setTermination_date(personaInputDTO.getTermination_date());
    }
}
