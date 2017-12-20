import java.util.*;

class WordOrder {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String wordsFirst [] = scanner.nextLine().split("\\s+");

		List<NewWord> wordOccs = new ArrayList<NewWord>();

		int nWords = 0;

		// Considero solo le parole distinte
		List<String> words = new ArrayList<String>();
		boolean isNew;
		for (String w1: wordsFirst) {
			isNew = true;
			for (String w2: words)
				if (w1.equals(w2)) {
					isNew = false;
					break;
				}
			if (isNew) {
				words.add(w1);
				nWords++;
			}
		}



		DiGraph graph = new DiGraph(nWords);

		StringBuilder dotGraph = new StringBuilder();
		dotGraph.append("digraph G_T {\n");

		// Nodi
		for (int i = 0; i < nWords; i++) {
			dotGraph.append(i + " [label=\"" + words.get(i) + "\"];\n");
			wordOccs.add(new NewWord(words.get(i)));
		}

		// archi
		for (int i = 0; i < nWords; i++) {
			for (int j = 0; j < nWords; j++) {
				if (wordOccs.get(j).lessThan(wordOccs.get(i))) {
					dotGraph.append(i + " -> " + j + ";\n");
					graph.connect(i,j);
				}
			}
		}

		dotGraph.append("}");

		System.out.println(graph.diameter());
		System.out.println(dotGraph);

	}
}