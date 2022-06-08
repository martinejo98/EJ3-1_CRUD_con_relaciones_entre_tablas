package com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.dto.output;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.output.EstudianteOutputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutputDTOEstudiante extends PersonaOutputDTO{

    private EstudianteOutputDTO estudianteOutputDTO;

    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;

    public PersonaOutputDTOEstudiante(Persona persona){
        super(persona);
        setId_student(estudianteOutputDTO.getId_student());
        setNum_hours_week(estudianteOutputDTO.getNum_hours_week());
        setComents(estudianteOutputDTO.getComents());
        setId_profesor(estudianteOutputDTO.getId_profesor());
        setBranch(estudianteOutputDTO.getBranch());
    }

}
