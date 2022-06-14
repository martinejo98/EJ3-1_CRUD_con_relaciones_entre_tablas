package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante_asignatura.infrastructure.repository;

import com.example.BS9_Clase_RestTemplate_Usos_con_Feign.estudiante_asignatura.domain.Estudiante_asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estudiante_asignaturaRepository extends JpaRepository<Estudiante_asignatura, String> {
}
