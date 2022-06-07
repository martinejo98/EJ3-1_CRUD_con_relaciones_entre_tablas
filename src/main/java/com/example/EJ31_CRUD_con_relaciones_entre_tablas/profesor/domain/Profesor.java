package com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.domain;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.PersonaSequenceIdGenerator;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.dto.input.ProfesorInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "profesor")
@Data
@NoArgsConstructor
public class Profesor {

    //Me crea un ID autoincrementable de String

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @GenericGenerator(
            name = "idGenerator",
            strategy = "com.example.EJ31_CRUD_con_relaciones_entre_tablas.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROF"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            }
    )
    private String id_profesor;

    @OneToOne
    @JoinColumn(name = "id_persona")
    //@NotBlank
    private Persona persona;

    @Column(name = "Coments")
    private String coments;

    @NotBlank
    private String branch;

    public Profesor (ProfesorInputDTO profesorInputDTO){
        setComents(profesorInputDTO.getComents());
        setBranch(profesorInputDTO.getBranch());
    }
}
