package com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_student;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "horas_por_semana")
    private Integer num_hours_week;

    @Column(name = "comentarios")
    private String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column(name = "rama")
    private String branch;

    //@OneToMany
    //private List<Estudiante_asignatura> estudios;

}