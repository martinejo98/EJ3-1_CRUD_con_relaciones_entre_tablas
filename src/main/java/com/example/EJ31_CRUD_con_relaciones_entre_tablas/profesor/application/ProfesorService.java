package com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.application;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.repository.PersonaRepository;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.domain.Profesor;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.exception.NotFoundException;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.dto.input.ProfesorInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.dto.output.ProfesorOutputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.repository.ProfesorRepository;
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
