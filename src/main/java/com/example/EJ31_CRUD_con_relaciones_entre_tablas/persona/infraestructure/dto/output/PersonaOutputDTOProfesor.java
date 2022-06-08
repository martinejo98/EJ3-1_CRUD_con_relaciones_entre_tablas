package com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.dto.output;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.dto.output.ProfesorOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutputDTOProfesor extends PersonaOutputDTO{

    private ProfesorOutputDTO profesorOutputDTO;

    private String id_profesor;
    private String coments;
    private String branch;

    public PersonaOutputDTOProfesor(Persona persona){
        super(persona);
        setId_profesor(profesorOutputDTO.getId_profesor());
        setComents(profesorOutputDTO.getComents());
        setBranch(profesorOutputDTO.getBranch());
    }
}
