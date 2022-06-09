package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.application;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.exception.NotFoundException;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.input.EstudianteInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.output.EstudianteOutputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.dto.output.EstudianteOutputDTOFull;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.repository.EstudianteRepository;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.repository.PersonaRepository;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.domain.Profesor;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.infraestructure.repository.ProfesorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    ModelMapper modelMapper;

    public EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO){
        Persona persona = personaRepository.findById(estudianteInputDTO.getPersona()).orElseThrow(()-> new NotFoundException("No se ha encontrado a la persona"));
        Profesor profesor = profesorRepository.findById(estudianteInputDTO.getProfesor()).orElseThrow(()-> new NotFoundException("No se ha encontrado al profesor"));
        Estudiante estudianteEntity = new Estudiante(estudianteInputDTO);
        estudianteEntity.setPersona(persona);
        estudianteEntity.setProfesor(profesor);
        estudianteRepository.save(estudianteEntity);
        return new EstudianteOutputDTO(estudianteEntity);
    }

    public EstudianteOutputDTO getEstudiante(String id){
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(()-> new NotFoundException("No se ha encontrado al estudiante con el ID: "+id));
        return new EstudianteOutputDTO(estudiante);
    }

    public EstudianteOutputDTOFull getEstudianteFull(String id){
        Estudiante estudiante = estudianteRepository .findById(id).orElseThrow(()-> new NotFoundException("No se ha encontrado al estudiante con el ID: "+id));
        EstudianteOutputDTOFull estudianteOutputDTOFull = new EstudianteOutputDTOFull(estudiante);
        return estudianteOutputDTOFull;
    }

    public EstudianteOutputDTO updateEstudiante(String id, EstudianteInputDTO estudianteInputDTO){
        Optional <Estudiante> estudiante = estudianteRepository.findById(id);
        if(estudiante.isPresent()){
            estudianteInputDTO.setPersona(Optional.ofNullable(estudianteInputDTO.getPersona()).orElse(estudiante.get().getPersona().getId_persona()));
            estudianteInputDTO.setNum_hours_week(Optional.ofNullable(estudianteInputDTO.getNum_hours_week()).orElse(estudiante.get().getNum_hours_week()));
            estudianteInputDTO.setComents(Optional.ofNullable(estudianteInputDTO.getComents()).orElse(estudiante.get().getComents()));
            estudianteInputDTO.setProfesor(Optional.ofNullable(estudianteInputDTO.getProfesor()).orElse(estudiante.get().getProfesor().getId_profesor()));
            estudianteInputDTO.setBranch(Optional.ofNullable(estudianteInputDTO.getBranch()).orElse(estudiante.get().getBranch()));
            //estudianteInputDTO.setEstudios( Optional.ofNullable(estudianteInputDTO.getEstudios()) .orElse(estudiante.get().getEstudios()));

            estudianteRepository.saveAndFlush(modelMapper.map(estudianteInputDTO, Estudiante.class));
            EstudianteOutputDTO estudianteOutputDTO = modelMapper.map(estudianteInputDTO, EstudianteOutputDTO.class);
            return estudianteOutputDTO;
        }else{
            throw new NotFoundException("No esxite el estudiante con el id: "+id);
        }
    }

    public String deleteEstudiante(String id) throws NotFoundException{
        Optional <Estudiante> estudiante = estudianteRepository.findById(id);
        if(estudiante.isPresent()){
            estudianteRepository.deleteById(id);
            return "Estudiante eliminado de la BBDD";
        }else{
            throw new NotFoundException("No se ha encontrado a ingún estudiante con el id: "+id);
        }
    }

}
