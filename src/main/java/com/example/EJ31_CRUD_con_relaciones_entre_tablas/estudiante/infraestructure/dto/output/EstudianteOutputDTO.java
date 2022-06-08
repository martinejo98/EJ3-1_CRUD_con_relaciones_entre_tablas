package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.output;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain.Estudiante_asignatura;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EstudianteOutputDTO{

    private String id_student;
    private String id_persona;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;
    //private List<Estudiante_asignatura> estudios;

    public EstudianteOutputDTO(Estudiante estudiante) {
        setId_student(estudiante.getId_student());
        setId_persona(estudiante.getPersona().getId_persona());
        setId_profesor(estudiante.getProfesor().getId_profesor());
        setComents(estudiante.getComents());
        setBranch(estudiante.getBranch());
        setNum_hours_week(estudiante.getNum_hours_week());
    }
}
