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

	public int length;

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
		length = raw.length();
		for (char c: raw.toCharArray())
			add(c);
	}

	public String toString() {
		String out = "";
		for (Pair occ: occurrences)
			out += occ.c + ":" + occ.n + '\n';
		return out;
	}

	public boolean leq(NewWord other) {
		for (Pair occ: occurrences)
			if (other.get(occ.c) < occ.n)
				return false;
		return true;
	}

	public boolean lessThan(NewWord other) {
		return (length < other.length) && leq(other);
	}

//	public boolean geq(NewWord other) {
//		return other.leq(this);
//	}
}
