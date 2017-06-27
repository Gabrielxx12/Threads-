package so;
import java.lang.*;
import java.util.concurrent.Semaphore;
    public class Impressora extends Thread {
           private static Armazem armzm = new Armazem();
           Semaphore semaforo;

           public synchronized static void entrarRegiaoCritica() {
                   for (int i = 0; i <= 100; i++) {
                           System.out.println("Impressora " + armzm.armazem);
                           try {
                                   Thread.sleep(100);
                           } catch (InterruptedException e) {
                                   e.printStackTrace();
                           }
                   }
           }

           public void run() {
                   entrarRegiaoCritica();
                   try {
                           semaforo.acquire();
                   } catch (InterruptedException e) {
                           e.printStackTrace();
                   } finally {
                           semaforo.release();
                   }
           }
   }

