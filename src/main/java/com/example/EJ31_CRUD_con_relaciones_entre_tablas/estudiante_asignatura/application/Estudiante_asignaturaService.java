package com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.application;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.domain.Estudiante;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante.infraestructure.repository.EstudianteRepository;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.domain.Estudiante_asignatura;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.dto.input.Estudiante_asignaturaInputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.dto.output.Estudiante_asignaturaOutputDTO;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.estudiante_asignatura.infrastructure.repository.Estudiante_asignaturaRepository;
import com.example.EJ31_CRUD_con_relaciones_entre_tablas.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Estudiante_asignaturaService {

    @Autowired
    Estudiante_asignaturaRepository estudiante_asignaturaRepository;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    ModelMapper modelMapper;

    public Estudiante_asignaturaOutputDTO addAsignatura(Estudiante_asignaturaInputDTO estudiante_asignaturaInputDTO){
        Estudiante_asignatura estudiante_asignatura = estudiante_asignaturaRepository.save(modelMapper.map(estudiante_asignaturaInputDTO, Estudiante_asignatura.class));
        return modelMapper.map(estudiante_asignatura, Estudiante_asignaturaOutputDTO.class);
    }

    public Estudiante_asignaturaOutputDTO getEstudianteAsignatura(String id){
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(()-> new NotFoundException("No existe el estudiante con id: "+id));
        ////Continuar/////
        Estudiante_asignaturaOutputDTO estudiante_asignaturaOutputDTO = modelMapper.map(estudiante, Estudiante_asignaturaOutputDTO.class);
        return estudiante_asignaturaOutputDTO;
    }

    public Estudiante_asignaturaOutputDTO updateAsignatura(String id, Estudiante_asignaturaInputDTO estudiante_asignaturaInputDTO){
        Optional<Estudiante_asignatura> Estuadiante_asigantura = estudiante_asignaturaRepository.findById(id);
        if(Estuadiante_asigantura.isPresent()){

            estudiante_asignaturaInputDTO.setAsignatura(Optional.ofNullable(estudiante_asignaturaInputDTO.getAsignatura()).orElse(Estuadiante_asigantura.get().getAsignatura()));
            estudiante_asignaturaInputDTO.setComents(Optional.ofNullable(estudiante_asignaturaInputDTO.getComents()).orElse(Estuadiante_asigantura.get().getComment()));
            estudiante_asignaturaInputDTO.setInitial_date(Optional.ofNullable(estudiante_asignaturaInputDTO.getInitial_date()).orElse(Estuadiante_asigantura.get().getInitial_date()));
            estudiante_asignaturaInputDTO.setFinish_date(Optional.ofNullable(estudiante_asignaturaInputDTO.getFinish_date()).orElse(Estuadiante_asigantura.get().getFinish_date()));
            estudiante_asignaturaInputDTO.setId_estudiante(Optional.ofNullable(estudiante_asignaturaInputDTO.getId_estudiante()).orElse(Estuadiante_asigantura.get().getStudent().getId_student()));

            estudiante_asignaturaRepository.saveAndFlush(modelMapper.map(estudiante_asignaturaInputDTO, Estudiante_asignatura.class));
            Estudiante_asignaturaOutputDTO estudiante_asignaturaOutputDTO = modelMapper.map(estudiante_asignaturaInputDTO, Estudiante_asignaturaOutputDTO.class);
            return estudiante_asignaturaOutputDTO;
        } else {
            throw new NotFoundException("No se ha encontrado a nadie con el id: "+id);
        }
    }

    public String deleteAsignatura(String id) throws NotFoundException{
        Optional <Estudiante_asignatura> estudiante_asignatura = estudiante_asignaturaRepository.findById(id);
        if(estudiante_asignatura.isPresent()){
            estudiante_asignaturaRepository.deleteById(id);
            return "Asignatura eliminada";
        }else{
            throw new NotFoundException("No se ha encontrado la asigantura con el id: "+id);
        }
    }
}
