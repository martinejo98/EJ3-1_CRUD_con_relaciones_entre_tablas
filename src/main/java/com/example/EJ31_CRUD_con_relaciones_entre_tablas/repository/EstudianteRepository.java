package com.example.EJ31_CRUD_con_relaciones_entre_tablas.repository;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
