import java.util.*;

public class NewWord {

	class Pair {
		public char c;
		public int n;
		public Pair(char x, int y) {
			c = x;
			n = y;
		}
	};

	List<Pair> occurrences;

	public void add(char c) {
		for (Pair occ: occurrences)
			if (occ.c == c) {
				occ.n++;
				return;
			}

		occurrences.add(new Pair(c,1));
	}

	public int get(char c) {
		for (Pair occ: occurrences)
			if (occ.c == c)
				return occ.n;
		return 0;
	}

	public NewWord(String raw) {
		occurrences = new ArrayList<Pair>();

		for (char c: raw.toCharArray())
			add(c);
	}

}
