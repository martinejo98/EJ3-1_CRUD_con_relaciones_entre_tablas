package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante_asignatura.domain;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.PersonaSequenceIdGenerator;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "asignaturas")
@NoArgsConstructor
public class Estudiante_asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @GenericGenerator(
            name = "idGenerator",
            strategy = "com.example.BS9_Clase_RestTemplate_Usos_con_Feign.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ASIG"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String id_study;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Estudiante> student;

    @Column(name = "asignatura")
    private String asignatura;

    @Column(name = "comentarios")
    private String comment;

    @Column(name = "initial_date")
    private Date initial_date;

    @Column(name = "finish_date")
    private Date finish_date;

}
