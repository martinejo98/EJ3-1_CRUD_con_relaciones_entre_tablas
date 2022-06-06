package com.example.EJ31_CRUD_con_relaciones_entre_tablas.application.service;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Persona;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.exception.NotFoundException;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.input.EstudianteInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.output.EstudianteOutputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.infrastructure.dto.output.EstudianteOutputDTOFull;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.repository.EstudianteRepository;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.repository.PersonaRepository;
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
    ModelMapper modelMapper;

    public EstudianteInputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO){
        estudianteRepository.save(modelMapper.map(estudianteInputDTO, Estudiante.class));
        return estudianteInputDTO;
    }

    public EstudianteOutputDTO getEstudiante(int id){
        Estudiante estudiante = estudianteRepository .findById(id).orElseThrow(()-> new NotFoundException("No se ha encontrado al estudiante con el ID: "+id));
        EstudianteOutputDTO estudianteOutputDTO = modelMapper.map(estudiante, EstudianteOutputDTO.class);
        return estudianteOutputDTO;
    }


    public EstudianteOutputDTO updateEstudiante(int id, EstudianteInputDTO estudianteInputDTO){
        Optional <Estudiante> estudiante = estudianteRepository.findById(id);
        if(estudiante.isPresent()){
            //estudianteInputDTO.setId_student(id);
            //estudianteInputDTO.setPersona(Optional.ofNullable(estudianteInputDTO.getPersona()).orElse(estudiante.get().getPersona()));
            estudianteInputDTO.setNum_hours_week(Optional.ofNullable(estudianteInputDTO.getNum_hours_week()).orElse(estudiante.get().getNum_hours_week()));
            estudianteInputDTO.setComents(Optional.ofNullable(estudianteInputDTO.getComents()).orElse(estudiante.get().getComents()));
            //estudianteInputDTO.setProfesor(Optional.ofNullable(estudianteInputDTO.getProfesor()).orElse(estudiante.get().getProfesor()));
            estudianteInputDTO.setBranch(Optional.ofNullable(estudianteInputDTO.getBranch()).orElse(estudiante.get().getBranch()));
            //estudianteInputDTO.setEstudios( Optional.ofNullable(estudianteInputDTO.getEstudios()) .orElse(estudiante.get().getEstudios()));

            estudianteRepository.saveAndFlush(modelMapper.map(estudianteInputDTO, Estudiante.class));
            EstudianteOutputDTO estudianteOutputDTO = modelMapper.map(estudianteInputDTO, EstudianteOutputDTO.class);
            return estudianteOutputDTO;
        }else{
            throw new NotFoundException("No esxite el estudiante con el id: "+id);
        }
    }

    public String deleteEstudiante(int id) throws NotFoundException{
        Optional <Estudiante> estudiante = estudianteRepository.findById(id);
        if(estudiante.isPresent()){
            estudianteRepository.deleteById(id);
            return "Estudiante eliminado de la BBDD";
        }else{
            throw new NotFoundException("No se ha encontrado a ingún estudiante con el id: "+id);
        }
    }
}
