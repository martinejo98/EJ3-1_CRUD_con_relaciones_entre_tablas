package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.PersonaSequenceIdGenerator;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "asignaturas")
@NoArgsConstructor
public class Estudiante_asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @GenericGenerator(
            name = "idGenerator",
            strategy = "com.example.EJ31_CRUD_con_relaciones_entre_tablas.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ASIG"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Estudiante student;

    @Column(name = "asignatura")
    private String asignatura;

    @Column(name = "comentarios")
    private String comment;

    @Column(name = "initial_date")
    private Date initial_date;

    @Column(name = "finish_date")
    private Date finish_date;
}
