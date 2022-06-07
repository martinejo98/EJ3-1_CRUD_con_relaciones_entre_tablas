package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.domain.Profesor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "estudios")
public class Estudiante_asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_study;

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
