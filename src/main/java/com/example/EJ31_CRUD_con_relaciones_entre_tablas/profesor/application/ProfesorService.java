package com.example.EJ31_CRUD_con_relaciones_entre_tablas.profesor.application;

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
    ModelMapper modelMapper;

    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        Profesor p = modelMapper.map(profesorInputDTO, Profesor.class);

        profesorRepository.save(modelMapper.map(profesorInputDTO, Profesor.class));
        return modelMapper.map(profesorInputDTO, ProfesorOutputDTO.class);
    }

    public ProfesorOutputDTO getProfesor(String id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(()-> new NotFoundException("No se ha encontrado a nadie con el id: "+id));
        ProfesorOutputDTO profDTO = modelMapper.map(profesor, ProfesorOutputDTO.class);
        return profDTO;
    }

    public ProfesorOutputDTO updateProfesor(ProfesorInputDTO profesorInputDTO, String id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if(profesor.isPresent()){

            profesorInputDTO.setId_profesor(id);


            profesorRepository.saveAndFlush(modelMapper.map(profesorInputDTO, Profesor.class));
            ProfesorOutputDTO profDTO = modelMapper.map(profesorInputDTO, ProfesorOutputDTO.class);
            return profDTO;
        } else {
            throw new NotFoundException("No se ha encontrado a nadie con el id: "+id);
        }
    }

    public String deleteProfesor(String id) throws NotFoundException{
        Optional <Profesor> profesor = profesorRepository.findById(id);
        if(profesor.isPresent()){
            profesorRepository.deleteById(id);
            return "Profesor eliminado";
        }else{
            throw new NotFoundException("No se ha encontrado a nadie con el id: "+id);
        }
    }
}
