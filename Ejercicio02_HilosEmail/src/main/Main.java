package main;
import Hilos.BufferEmails;
import Hilos.ConsumidorEmails;
import Hilos.ProductorEmails;

public class Main {
    public static void main(String[] args) {

        BufferEmails emails = new BufferEmails();

        ProductorEmails p1 = new ProductorEmails(emails);
        ProductorEmails p2 = new ProductorEmails(emails);
        ProductorEmails p3 = new ProductorEmails(emails);

        ConsumidorEmails c1 = new ConsumidorEmails(emails);
        ConsumidorEmails c2 = new ConsumidorEmails(emails);
        ConsumidorEmails c3 = new ConsumidorEmails(emails);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
    }
}