package matriz;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplicaMatriz {

	public static void main(String[] args) {
		final Random generator = new Random();
		int n = 1702;
		int qtdeThreads = 3;
		int[][] A = new int[n][n];
		int[][] B = new int[n][n];
		int[][] C = new int[n][n];
		
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				A[a][b] = 1;generator.nextInt(20);
				B[a][b] = 1;generator.nextInt(20);
			}
		}
		
		/*CalculaMultiplicacao par = new CalculaMultiplicacao(A, B, C, n, true);
		CalculaMultiplicacao impar = new CalculaMultiplicacao(A, B, C, n, false);
		
		executor.execute(par);
		executor.execute(impar);*/

		long tempoInicial = System.currentTimeMillis();
		
		for (int i =0 ; i < qtdeThreads; i++) {
			CalculaMultiplicacao cm = new CalculaMultiplicacao(A,B,C,n,qtdeThreads);
			executor.execute(cm);
		}
		
		executor.shutdown();
		
		while(!executor.isTerminated()){}

		long tempoFinal = System.currentTimeMillis();
		System.out.println("Segundos: " + ((tempoFinal - tempoInicial)/1000));

	}
}
