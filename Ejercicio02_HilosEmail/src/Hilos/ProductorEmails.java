package Hilos;

public class ProductorEmails extends Thread {

	private BufferEmails be;
	
    public ProductorEmails(BufferEmails be) {
        this.be = be;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
        	Email email = new Email(i, "pibe@gmail.com", "tratamiento de hilos", "Este mensaje es el correo con el identificador unico " + i  + " creado por el " + i, "Este mail es un ejemplo");
            be.agregarMensaje(email);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

}
