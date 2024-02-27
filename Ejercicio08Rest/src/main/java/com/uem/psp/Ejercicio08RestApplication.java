package com.uem.psp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.uem.psp.modelo.entidad.Videojuego;
import com.uem.psp.modelo.persistencia.VideojuegoDao;

@SpringBootApplication
public class Ejercicio08RestApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Ejercicio08RestApplication.class, args);
		VideojuegoDao vDao = context.getBean("videojuegoDao", VideojuegoDao.class);
		
		Videojuego v = new Videojuego();
		v.setNombre("Mario");
		v.setCompania("Nintendo");
		v.setNota(10);
		
		vDao.save(v);
	}

}
