package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.infraestructure.dto.output;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstudianteOutputDTOFull extends EstudianteOutputDTO {

    private String id_persona;
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private String created_date;
    private String imagen_url;
    private String termination_date;

    public EstudianteOutputDTOFull(Estudiante estudiante){
        super(estudiante);
        setId_persona(estudiante.getPersona().getId_persona());
        setUsuario(estudiante.getPersona().getUsuario());
        setName(estudiante.getPersona().getName());
        setSurname(estudiante.getPersona().getSurname());
        setCompany_email(estudiante.getPersona().getCompany_email());
        setPersonal_email(estudiante.getPersona().getPersonal_email());
        setCity(estudiante.getPersona().getCity());
        setActive(estudiante.getPersona().getActive());
        setCreated_date(estudiante.getPersona().getCreated_date());
        setImagen_url(estudiante.getPersona().getImagen_url());
        setTermination_date(estudiante.getPersona().getTermination_date());
    }

}
