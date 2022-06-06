package com.example.EJ31_CRUD_con_relaciones_entre_tablas.repository;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository <Profesor, String> {
}
