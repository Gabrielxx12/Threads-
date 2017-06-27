package so;

     public class Executar {
	public static void main(String[] a) {
		
		Contador cont = new Contador();
		Impressora imp = new Impressora();
		new Contador().start();
		new Impressora().start();
	}
}


