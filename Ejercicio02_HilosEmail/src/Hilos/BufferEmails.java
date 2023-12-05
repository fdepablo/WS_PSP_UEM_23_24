package Hilos;

import java.util.LinkedList;
import java.util.Queue;

public class BufferEmails {
    private Queue<Email> emailEnBuffer;


    public BufferEmails() {
        emailEnBuffer = new LinkedList<>();
    }

    public synchronized void agregarMensaje(Email email) {
    	if (email.getDestinatario().equalsIgnoreCase("pikachu@gmail.com")) {
            System.out.println("\nALERTA!!!!\nDestinatario prohibido, se ha bloqueado el deposito del email en el buffer por el hilo \n" +
                    "El email se ha borrado y el hilo prosigue con sus tareas de consumir emails\n");
    	}else {
    		
	        while (emailEnBuffer.size() > 3) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        emailEnBuffer.add(email);
	        notify();
    	}
    }

    public synchronized Email consumirMensaje() {
        while (emailEnBuffer.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Email email= emailEnBuffer.poll();
        return email;
    }

}
