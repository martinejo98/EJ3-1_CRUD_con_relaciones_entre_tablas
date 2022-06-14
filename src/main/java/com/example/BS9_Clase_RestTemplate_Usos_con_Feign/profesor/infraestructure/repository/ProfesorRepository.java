package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.infraestructure.repository;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository <Profesor, String> {
}
