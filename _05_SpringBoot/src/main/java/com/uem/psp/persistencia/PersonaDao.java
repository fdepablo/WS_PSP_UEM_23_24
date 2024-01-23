package com.uem.psp.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uem.psp.entidad.Persona;

@Repository
public interface PersonaDao extends JpaRepository<Persona, Integer>{

}
