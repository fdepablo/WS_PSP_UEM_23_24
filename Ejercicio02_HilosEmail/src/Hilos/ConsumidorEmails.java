package Hilos;


public class ConsumidorEmails extends Thread {

	private BufferEmails be;
	
    public ConsumidorEmails(BufferEmails buffer) {
    	this.be = buffer;
    }

    @Override
    public void run() {
        int contador = 1;
        boolean dsp = true;
        while (dsp) {
            System.out.println(be.consumirMensaje());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            contador++;
            if (contador == 11){
                dsp = false;
            }
        }
    }
}
