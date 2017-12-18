import java.util.*;

public class NewWord {

	class Pair {
		public char c;
		public short n;
		public Pair(char x, short y) {
			c = x;
			n = y;
		}
	};

	List<Occurrence> occurrences;

	public void add(char c) {
		for (char occ: occurrences)
			if (occ.c == c) {
				occ.n++;
				return;
			}

		pair.add(new Pair(c,1));
	}

	public short get(char c) {
		for (char occ: occurrences)
			if (occ.c == c)
				return occ.n;
		return 0;
	}

	public NewWord(String raw) {
		occurrences = new ArrayList<Pair>();

		for (char c: raw)
			add(c);
	}

}
