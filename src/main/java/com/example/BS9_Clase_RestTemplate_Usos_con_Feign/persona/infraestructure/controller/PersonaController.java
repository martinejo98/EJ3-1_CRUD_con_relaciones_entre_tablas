package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.infraestructure.controller;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.application.EstudianteService;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.feign.IFeignServer;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.application.PersonaService;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.exception.UnprocesableException;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.infraestructure.dto.input.PersonaInputDTO;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.infraestructure.dto.output.PersonaOutputDTO;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.application.ProfesorService;
import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.dto.output.ProfesorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/addPersona")
    public PersonaOutputDTO addPersona(@RequestBody @Valid PersonaInputDTO personaInputDTO) throws Exception {            //@valid valida que lso datos que le paso sean correctos.
        return personaService.addPersona(personaInputDTO);
    }

    @GetMapping("/getPersonaID/{id}")
    public PersonaOutputDTO getPersonaByID(@RequestParam(value = "outputType", defaultValue = "persona") String outputType, @PathVariable String id){
        if(outputType.equals("profesor")){
            return personaService.getPersonaByIDProfesor(id);
        }else if(outputType.equals("estudiante")){
            return personaService.getPersonaByIDEstudiante(id);
        }else{
            return personaService.getPersonaByID(id);
        }
    }


    @GetMapping("/getPersonaName/{name}")
    public List<PersonaOutputDTO> getPersonaByName(@RequestParam(value = "outputType", defaultValue = "persona") String outputType, @PathVariable String name){
        if(outputType.equals("profesor")){
            return personaService.getPersonaByNameProfesor(name);
        }else if(outputType.equals("estudiante")){
            return personaService.getPersonaByNameEstudiante(name);
        }else{
            return personaService.getPersonaByName(name);
        }
    }

    @GetMapping("/getAll")
    public List <PersonaOutputDTO> getAll(@RequestParam(value = "outputType", defaultValue = "simple") String outputType){
        if(outputType.equals("full")){
            return personaService.getAllFull();
        }else{
            return personaService.getAll();
        }
    }

    @PutMapping("/update/{id}")
    public String updatePersona(@RequestBody @Valid PersonaInputDTO persona, @PathVariable String id) throws UnprocesableException{
        checkPersona(persona);
        personaService.updatePersona(id, persona);
        return "Persona actualziada";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable String id) {
        personaService.deletePersona(id);
        return "Persona eliminada";
    }

    private void checkPersona(PersonaInputDTO personaInputDTO) {
        if (personaInputDTO == null) {
            throw new UnprocesableException("No se puede introducir una persona sin información");
        }
        if (personaInputDTO.getUsuario() == null) {
            throw new UnprocesableException("El campo Usuario no puede ser nulo");
        }
        if (personaInputDTO.getUsuario() == null || personaInputDTO.getUsuario().isBlank()) {
            throw new UnprocesableException("El campo Usuario no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getUsuario().length() > 10) {
            throw new UnprocesableException(
                    "El campo Usuario debe tener como máximo 10 caracteres de longitud");
        }
        if (personaInputDTO.getUsuario().length() < 6) {
            throw new UnprocesableException(
                    "El campo Usuario debe tener como mínimo 6 caracteres de longitud");
        }
        if (personaInputDTO.getPassword() == null) {
            throw new UnprocesableException("El campo Password no puede ser nulo");
        }
        if (personaInputDTO.getPassword() == null || personaInputDTO.getPassword().isBlank()) {
            throw new UnprocesableException("El campo Password no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getName() == null) {
            throw new UnprocesableException("El campo nombre no puede ser nulo");
        }
        if (personaInputDTO.getName() == null || personaInputDTO.getName().isBlank()) {
            throw new UnprocesableException("El campo nombre no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCompany_email() == null) {
            throw new UnprocesableException("El campo Company_Email no puede ser nulo");
        }
        if (personaInputDTO.getCompany_email() == null
                || personaInputDTO.getCompany_email().isBlank()) {
            throw new UnprocesableException("El campo Company_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getPersonal_email() == null) {
            throw new UnprocesableException("El campo Personal_Email no puede ser nulo");
        }
        if (personaInputDTO.getPersonal_email() == null
                || personaInputDTO.getPersonal_email().isBlank()) {
            throw new UnprocesableException("El campo Personal_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCity() == null) {
            throw new UnprocesableException("El campo Ciudad no puede ser nulo");
        }
        if (personaInputDTO.getCity() == null || personaInputDTO.getCity().isBlank()) {
            throw new UnprocesableException("El campo Ciudad no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCreated_date() == null) {
            throw new UnprocesableException("El campo Created-Date no puede ser nulo");
        }
    }


    ////////////////////////////////////////////RestTemplate////////////////////////////////////////////

    /*@GetMapping("/profesor/{id}")
    public ProfesorOutputDTO getProfesorRestTemplate(@PathVariable String id){

        ResponseEntity<ProfesorOutputDTO> personaOutputDTOResponseEntity = new RestTemplate().getForEntity("http://localhost:8081/profesor/getProfesor/"+id, ProfesorOutputDTO.class);
        if(personaOutputDTOResponseEntity.getStatusCode()==HttpStatus.OK){
            return personaOutputDTOResponseEntity.getBody();
        }throw new RuntimeException("No está OK");
    }*/




    ///////////////////////////////////////////////Feign///////////////////////////////////////////////

    @Autowired
    IFeignServer iFeignServer;

    @GetMapping("/profesor/{id}")
    public ProfesorOutputDTO getProfesorFeign(@PathVariable String id){
        return iFeignServer.getProfesorFeign(id);
    }

}