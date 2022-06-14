package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.application;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.domain.Persona;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.infraestructure.repository.PersonaRepository;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.domain.Profesor;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.exception.NotFoundException;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.input.ProfesorInputDTO;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.output.ProfesorOutputDTO;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.repository.ProfesorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ModelMapper modelMapper;

    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        Persona persona = personaRepository.findById(profesorInputDTO.getPersona()).orElseThrow(()-> new NotFoundException("No se ha encontrado"));
        Profesor profesorEntity = new Profesor(profesorInputDTO);
        profesorEntity.setPersona(persona);
        profesorRepository.save(profesorEntity);
        return new ProfesorOutputDTO(profesorEntity);
    }

    public ProfesorOutputDTO getProfesor(String id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(()-> new NotFoundException("No se ha encontrado al profesor con el id: "+id));
        ProfesorOutputDTO profesorOutputDTO = modelMapper.map(profesor, ProfesorOutputDTO.class);
        profesorOutputDTO.setId_persona(profesor.getPersona().getId_persona());
        return profesorOutputDTO;
    }

    public ProfesorOutputDTO updateProfesor(ProfesorInputDTO profesorInputDTO, String id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if(profesor.isPresent()){

            profesorRepository.saveAndFlush(modelMapper.map(profesorInputDTO, Profesor.class));
            ProfesorOutputDTO profDTO = modelMapper.map(profesorInputDTO, ProfesorOutputDTO.class);
            return profDTO;
        } else {
            throw new NotFoundException("No se ha encontrado al profesor con el id: "+id);
        }
    }

    public String deleteProfesor(String id) throws NotFoundException{
        Optional <Profesor> profesor = profesorRepository.findById(id);
        if(profesor.isPresent()){
            profesorRepository.deleteById(id);
            return "Profesor eliminado";
        }else{
            throw new NotFoundException("No se ha encontrado al profesor con el id: "+id);
        }
    }
}
