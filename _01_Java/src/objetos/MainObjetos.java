package objetos;

import java.util.ArrayList;
import java.util.List;

public class MainObjetos {

	public static void main(String[] args) {
		int numero = 5;
		// TODO Auto-generated method stub
		
		new Persona();
		
		Persona p1 = new Persona();
		Object o = p1;
		
		p1.setEdad(44);
		
		var p2 = p1;
		p2.setEdad(55);
		
		//55 55 /  44 55
		System.out.println(p1.getEdad());
		System.out.println(p2.getEdad());
		
		numero = 10;
		
		p1 = null;
		
		int numero2 = 20;
		
		numero2 = numero;
		numero2 = 100;
		
		System.out.println(numero);
		System.out.println(numero2);
		
		Persona p4 = null;
		{
			Persona p3 = new Persona();
			p3.setNombre("illojuan");
			
			cambiarNombre(p3);
			System.out.println(p3.getNombre());
			p4 = p3;
		}//La referencia p3 va a morir :(
		
		//p3.setNombre("fe");
		
		List<Persona> listaPersonas = new ArrayList<>();
		Persona p5 = new Persona();
		listaPersonas.add(p5);
		
		p5.setNombre("Ibai");
	
		System.out.println(listaPersonas);
		
		listaPersonas.add(p4);
		
		listaPersonas.get(0).setNombre("Tomasin");
		System.out.println(p5.getNombre());
		
		p5 = p4;//he perdido a ibai
		listaPersonas.get(1).setNombre("Ana la loca");
		System.out.println(p5.getNombre());
		
		listaPersonas = null;
	}
	
	public static void cambiarNombre(Persona p) {
		p.setNombre("Nekro");
	}

}
