package com.uem.psp;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.uem.psp.entidad.Cliente;
import com.uem.psp.entidad.Persona;
import com.uem.psp.persistencia.PersonaDao;

//Esta anotación hace 2 cosas fundamentales
//1- Busca dentro de este paquete y de sus subpaquetes anotaciones
//spring para gestionar

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//Esta sentencia arranca el contexto de spring y carga
		//los objetos que hayamos dado de alta
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		Persona p1 = new Persona();
		
		Persona p2 = (Persona)context.getBean("persona67");
		p2.setNombre("Manuel");
		
		Persona p3 = context.getBean("persona67", Persona.class);
		System.out.println(p3.getNombre());
		
		p3 = context.getBean("persona2",Persona.class);
		System.out.println(p3.getNombre());
		p2 = null;
		p1 = null;
		
		p2 = (Persona)context.getBean("persona67");
		System.out.println(p2.getNombre());
		
		Cliente c1 = context.getBean("cliente",Cliente.class);
		System.out.println(c1.getEntidadBancaria().getNumeroCuenta());
		
		PersonaDao pDao = context.getBean("personaDao",PersonaDao.class);
		pDao.save(p2);
		
		Optional<Persona> op = pDao.findById(1);
		if(op.isPresent()) {
			System.out.println(op.get());
		}
	}
	
	//Podemos crear todos los "beans" que queramos con el @Bean
	//encima de un método, y se dará de alta en el contexto de spring
	//con el nombre del método
	@Bean
	public Persona persona2() {
		Persona p = new Persona();
		p.setNombre("El bicho");
		return p;
	}
	
	@Bean
	public Persona pepito() {
		Persona p = new Persona();
		p.setNombre("El bicho");
		return p;
	}

}
