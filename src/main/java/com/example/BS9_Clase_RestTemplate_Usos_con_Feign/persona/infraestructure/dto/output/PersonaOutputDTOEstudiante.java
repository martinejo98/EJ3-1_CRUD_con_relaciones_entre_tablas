package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.infraestructure.dto.output;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.infraestructure.dto.output.EstudianteOutputDTO;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutputDTOEstudiante extends PersonaOutputDTO{

    private EstudianteOutputDTO estudiante;

    public PersonaOutputDTOEstudiante (Persona persona){
        super(persona);
        setId_persona(persona.getId_persona());
        estudiante.setId_profesor(estudiante.getId_profesor());
    }
}
