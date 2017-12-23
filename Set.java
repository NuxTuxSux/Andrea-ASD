import java.util.*;

class Set<T extends Comparable<T>> {
	private List<T> repr;
	private int size;
	public int size() {
		return size;
	}

	public void add(T x) {
		int i;
		for (i = 0; i < repr.size(); i++) {
			int cmp = repr.get(i).compareTo(x);
			if (cmp == 0)
				return;
			if (cmp > 0)
				break;
		}
		repr.add(i,x);
		size++;
	}

	public Set(List<T> xs) {
		size = 0;
		repr = new LinkedList<T>();
		for (T x: xs)
			add(x);
	}

	public String toString() {
		String out = repr.toString();
		return "{" + repr.toString().substring(1,out.length()-1) + "}";
	}

	public List<T> asList() {
		return repr;
	}
}