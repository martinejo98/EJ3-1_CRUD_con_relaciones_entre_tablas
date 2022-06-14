package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.infraestructure.dto.output;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.domain.Persona;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.output.ProfesorOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutputDTOProfesor extends PersonaOutputDTO{

    private ProfesorOutputDTO profesor;

    public PersonaOutputDTOProfesor (Persona persona){
        super(persona);
        setId_persona(persona.getId_persona());
    }
}
