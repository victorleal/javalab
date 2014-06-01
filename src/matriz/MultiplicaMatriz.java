package matriz;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplicaMatriz {

	public static void main(String[] args) {
		final Random generator = new Random();
		int n = 5;
		int[][] A = new int[n][n];
		int[][] B = new int[n][n];
		int[][] C = new int[n][n];

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				A[a][b] = 1;generator.nextInt(20);
				B[a][b] = 1;generator.nextInt(20);
			}
		}
		
		CalculaMultiplicacao par = new CalculaMultiplicacao(A, B, C, n, true);
		CalculaMultiplicacao impar = new CalculaMultiplicacao(A, B, C, n, false);
		
		ExecutorService executor = Executors.newCachedThreadPool();

		long tempoInicial = System.currentTimeMillis();
		
		executor.execute(par);
		executor.execute(impar);
		
		executor.shutdown();
		
		while(!executor.isTerminated()){}

		long tempoFinal = System.currentTimeMillis();
		System.out.println("Segundos: " + ((tempoFinal - tempoInicial)/1000));
		
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				System.out.println(C[a][b]);
			}
		}

	}
}
