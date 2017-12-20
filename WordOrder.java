import java.util.*;

class WordOrder {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String words [] = scanner.nextLine().split("\\s+");
		List<NewWord> wordOccs = new ArrayList<NewWord>();

		int nWords = words.length;

		DiGraph graph = new DiGraph(nWords);

		StringBuilder dotGraph = new StringBuilder();
		dotGraph.append("digraph G_T {\n");
		// Nodi
		for (int i = 0; i < nWords; i++) {
			dotGraph.append(i + " [label=\"" + words[i] + "\"];\n");
			wordOccs.append(new NewWord(words[i]));
		}
		// archi
		for (int i = 0; i < nWords; i++) {
			for (int j = 0; j < nWords; j++) {
				if (wordOccs.get(j).lessThan(wordOccs.get(i))) {
					dotGraph.append(i + " -> " + j + ";");
					graph.connect(i,j);
				}
			}
		}

		dotGraph.append("}");

		System.out.println(dotGraph);

	}
}