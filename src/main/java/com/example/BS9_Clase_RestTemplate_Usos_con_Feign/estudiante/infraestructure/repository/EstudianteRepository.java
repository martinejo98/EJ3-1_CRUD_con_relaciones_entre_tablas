package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.infraestructure.repository;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

}
