package matriz;

public class CalculaMultiplicacao implements Runnable {

	int[][] A;
	int[][] B;
	int[][] C;

	int n = 0;

	int qtdeThreads = 0;

	boolean isPar;

	public CalculaMultiplicacao(int[][] A, int[][] B, int[][] C, int max,
			boolean isPar) {
		n = max;
		this.A = A;
		this.B = B;
		this.C = C;
		this.isPar = isPar;
	}

	public CalculaMultiplicacao(int[][] A, int[][] B, int[][] C, int max,
			int qtdeThreads) {
		n = max;
		this.A = A;
		this.B = B;
		this.C = C;
		this.qtdeThreads = qtdeThreads;
	}

	@Override
	public void run() {
		if (qtdeThreads != 0) {
			realizaMultiplicacaoPorThread();
		} else {
			if (isPar) {
				realizaMultiplicacaoPar();
			} else {
				realizaMultiplicacaoImpar();
			}
		}
	}

	public void realizaMultiplicacaoPar() {
		for (int i = 0; i < n; i = i + 2) {
			for (int j = 0; j < n; j++) {
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}

		}
	}

	public void realizaMultiplicacaoImpar() {
		for (int i = 1; i < n; i = i + 2) {
			for (int j = 0; j < n; j++) {
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}

		}
	}

	public void realizaMultiplicacaoPorThread() {
		for (int i = 1; i < n; i = i + qtdeThreads) {
			for (int j = 0; j < n; j++) {
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}

		}
	}
}
