import java.util.*;

class testDiGraph {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Numero di nodi:");

		int N = scanner.nextInt();
		DiGraph graph = new DiGraph(N);

		int a = 0, b = 0;
		while (true) {
			System.out.print("A:");
			a = scanner.nextInt();
			System.out.print("B:");
			b = scanner.nextInt();
			if (a <= -1 || b <= -1 || a >= N || b >= N)
				break;
			graph.connect(a,b);
		}

		System.out.println("Altezze:");
		for (int i = 0; i < N; i++)
			System.out.println(i + "->" + graph.height(i));
		System.out.println("Altezza massima:" + graph.diameter());
		
	}

}