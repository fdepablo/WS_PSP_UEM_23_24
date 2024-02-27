package com.uem.psp.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uem.psp.modelo.entidad.Videojuego;

@Repository
public interface VideojuegoDao extends JpaRepository<Videojuego, Integer>{

	public List<Videojuego> findByCompania(String compania);
}
