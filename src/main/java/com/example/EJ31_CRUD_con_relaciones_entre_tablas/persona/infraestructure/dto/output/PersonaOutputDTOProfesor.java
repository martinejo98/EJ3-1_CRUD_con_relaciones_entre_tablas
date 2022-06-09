package com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.dto.output;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.dto.output.ProfesorOutputDTO;
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
