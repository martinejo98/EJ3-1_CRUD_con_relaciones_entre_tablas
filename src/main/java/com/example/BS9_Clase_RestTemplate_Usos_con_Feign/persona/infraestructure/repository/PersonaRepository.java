package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.infraestructure.repository;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, String> {
}
