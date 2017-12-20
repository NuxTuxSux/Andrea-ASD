import java.util.*;

class DiGraph {

	public int N;
	private List<List<Integer>> sons;
	private List<Integer> heights;
	
	public DiGraph(int N) {
		this.N = N;
		this.sons = new ArrayList<List<Integer>>();
		this.heights = new ArrayList<Integer>();

		for (int node = 0; node < N; node++) {
			this.sons.add(new ArrayList<Integer>());
			heights.add(-1);
		}
	}

	public void connect(int parent, int son) {
		if (parent < N)
			sons.get(parent).add(son);
	}

	public int height(int node) {
		int h = heights.get(node);
		if (h > -1)
			return h;

		int maxHeight = -1;
		int presentHeight;
		for (int son: sons.get(node)) {
			presentHeight = height(son);
			if (presentHeight > maxHeight)
				maxHeight = presentHeight;
		}
		maxHeight++;

		heights.set(node,maxHeight);
		return maxHeight;
	}

	public int diameter() {
		int maxHeight = -1;
		int nodeHeight;
		for (int i = 0; i < N; i++) {
			nodeHeight = height(i);
			if (nodeHeight > maxHeight)
				maxHeight = nodeHeight;
		}
		return maxHeight;
	}
}