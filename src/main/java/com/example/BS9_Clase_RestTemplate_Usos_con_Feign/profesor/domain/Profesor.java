package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.domain;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.PersonaSequenceIdGenerator;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.domain.Persona;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.input.ProfesorInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

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
            strategy = "com.example.BS9_Clase_RestTemplate_Usos_con_Feign.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROF"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            }
    )
    private String id_profesor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "comentarios")
    private String coments;

    @Column(name = "rama")
    private String branch;

    public Profesor (ProfesorInputDTO profesorInputDTO){
        setComents(profesorInputDTO.getComents());
        setBranch(profesorInputDTO.getBranch());
    }
}
