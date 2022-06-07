package com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.infraestructure.repository;

import com.example.EJ31_CRUD_con_relaciones_entre_tablas.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, String> {
}
