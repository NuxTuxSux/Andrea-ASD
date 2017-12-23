import java.util.*;

class WordOrder {

	static final boolean SILENT = false;

	public static void main(String args[]) {
		String wordsFirst [];
		if (args.length > 0) {
			wordsFirst = new String [args.length];
			System.arraycopy(args, 0, wordsFirst, 0, args.length);
		} else {
			Scanner scanner = new Scanner(System.in);
			wordsFirst = scanner.nextLine().split("\\s+");
		}

		List<NewWord> wordOccs = new ArrayList<NewWord>();

		int nWords = 0;

		List<String> words = new ArrayList<String>();
		Set<String> setWords = new Set<String>(Arrays.asList(wordsFirst));
		nWords = setWords.size();
		words = setWords.asList();


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
		if (!SILENT) {
			System.out.println(graph.diameter());
			System.out.println(dotGraph);
		}

	}
}