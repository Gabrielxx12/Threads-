package so;
import java.lang.*;
import java.util.concurrent.Semaphore;
   
    public class Contador extends Thread {
            private static Armazem armzm = new Armazem();
            Semaphore semaforo;

            public synchronized static void entrarRegiaoCritica() {

                    for (int i = 0; i <= 100; i++) {
                            armzm.armazem = i;
                            System.out.println("Contador " + i);
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

   
