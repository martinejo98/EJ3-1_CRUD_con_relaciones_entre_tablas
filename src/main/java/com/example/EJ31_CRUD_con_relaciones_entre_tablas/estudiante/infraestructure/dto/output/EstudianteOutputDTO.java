package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.output;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstudianteOutputDTO{

    private String id_student;
    private String id_persona;
    private Integer num_hours_week;
    private String coments;
    //private Profesor profesor;
    private String branch;
    //private List<Estudiante_asignatura> estudios;

    public EstudianteOutputDTO(Estudiante estudiante) {
        setId_student(estudiante.getId_student());
        setId_persona(estudiante.getPersona().getId_persona());
        //setProfesor(estudiante.getProfesor());
        setComents(estudiante.getComents());
        setBranch(estudiante.getBranch());
        setNum_hours_week(estudiante.getNum_hours_week());
    }
}
