package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.domain;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.PersonaSequenceIdGenerator;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.infraestructure.dto.input.EstudianteInputDTO;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante_asignatura.domain.Estudiante_asignatura;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.domain.Persona;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.domain.Profesor;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Data
@NoArgsConstructor
public class Estudiante{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @GenericGenerator(
            name = "idGenerator",
            strategy = "com.example.BS9_Clase_RestTemplate_Usos_con_Feign.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ESTU"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    @Column(name ="id_estudiante")
    private String id_student;

    @OneToOne(cascade = CascadeType.ALL)
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

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "student")
    private List<Estudiante_asignatura> estudios;

    public Estudiante (EstudianteInputDTO estudianteInputDTO){
        setComents(estudianteInputDTO.getComents());
        setBranch(estudianteInputDTO.getBranch());
        setNum_hours_week(estudianteInputDTO.getNum_hours_week());
    }
}